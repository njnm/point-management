package com.spring.pointmanagement.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;

import com.spring.pointmanagement.enums.LocationTypes;
import com.spring.pointmanagement.exceptions.ApplicationException;
import com.spring.pointmanagement.models.Point;
import com.spring.pointmanagement.models.PointDto;
import com.spring.pointmanagement.models.ResponseObject;
import com.spring.pointmanagement.services.PointsService;

@RunWith(MockitoJUnitRunner.class)
public class PointManagementControllerTests {

	@InjectMocks
	PointsController pointsController = new PointsController();
	
	@Mock
	PointsService pointsService;
	
	@Mock
	BindingResult bindingResult;
	
	@Test
	public void testGetPoints() throws ApplicationException {
		List<Point> points = new ArrayList<>();
		
		Date testDate = new Date();
		
		Point point = new Point();
		point.setMeasurementLocation("EE");
		point.setMeasurementValue(10.5);
		point.setMeasurementYear(testDate);
		
		points.add(point);
		
		ResponseObject<List<PointDto>> response = new ResponseObject<List<PointDto>>(HttpStatus.OK.value(), "Points list fetched successfully.",points);
		
		Mockito.when(pointsService.getPointsByLocation(Mockito.any(LocationTypes.class))).thenReturn(points);

		Assert.assertTrue(pointsController.listPointByLocation(LocationTypes.EE).getStatus() == response.getStatus());
	}
	
	@Test
	public void testGetPointsNoResult() throws ApplicationException {
		List<Point> points = new ArrayList<>();
		
		ResponseObject<List<PointDto>> response = new ResponseObject<List<PointDto>>(HttpStatus.NOT_FOUND.value(), "Points not found.",points);
		
		Mockito.when(pointsService.getPointsByLocation(Mockito.any(LocationTypes.class))).thenReturn(points);

		Assert.assertTrue(pointsController.listPointByLocation(LocationTypes.EE).getStatus() == response.getStatus());
	}
	
	@Test
	public void testSavePoints() throws ApplicationException {
		Date testDate = new Date();
		
		Point point = new Point();
		point.setMeasurementLocation("EE");
		point.setMeasurementValue(10.5);
		point.setMeasurementYear(testDate);
				
		PointDto pointDto = new PointDto();
		pointDto.setMeasurementLocation(LocationTypes.EE);
		pointDto.setMeasurementValue(10.5);
		pointDto.setMeasurementYear(testDate);
		
		ResponseObject<Point> response = new ResponseObject<Point>(HttpStatus.OK.value(), "Points saved successfully.", point);
		
		Mockito.when(pointsService.savePoint(Mockito.any(PointDto.class))).thenReturn(point);
		Mockito.when(bindingResult.hasErrors()).thenReturn(false);
		
		ResponseObject<Point> mockResult = pointsController.savePoint(pointDto, bindingResult);

		Assert.assertTrue(mockResult.getResult().equals(response.getResult()));
	}
}
