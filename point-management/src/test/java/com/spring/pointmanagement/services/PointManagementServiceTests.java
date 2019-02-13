package com.spring.pointmanagement.services;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.spring.pointmanagement.enums.LocationTypes;
import com.spring.pointmanagement.exceptions.ApplicationException;
import com.spring.pointmanagement.models.Point;
import com.spring.pointmanagement.models.PointDto;
import com.spring.pointmanagement.models.PointHistory;
import com.spring.pointmanagement.repository.PointsHistoryRepository;
import com.spring.pointmanagement.repository.PointsRepository;
import com.spring.pointmanagement.services.impl.PointsServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class PointManagementServiceTests {
	@InjectMocks
	PointsService pointsService = new PointsServiceImpl();
	
	@Mock
	PointsRepository pointsRepository;
	
	@Mock
	PointsHistoryRepository pointsHistoryRepository;
	
	@Test
	public void testGetPoints() throws ApplicationException {
		Iterable<Point> point = new ArrayList<>();
		
		Mockito.when(pointsRepository.findAll()).thenReturn(point);

		Assert.assertEquals(pointsService.getPoints(), point);
	}
	
	@Test
	public void testSavePoints() throws ApplicationException {
		Date testDate = new Date();
		
		PointDto pointDto = new PointDto();
		pointDto.setMeasurementLocation(LocationTypes.EE);
		pointDto.setMeasurementValue(10.5);
		pointDto.setMeasurementYear(testDate);
		
		Point point = new Point();
		point.setMeasurementLocation(pointDto.getMeasurementLocation().toString());
		point.setMeasurementValue(pointDto.getMeasurementValue());
		point.setMeasurementYear(pointDto.getMeasurementYear());
		
		PointHistory pointHistory = new PointHistory();
		pointHistory.setMeasurementLocation("EE");
		pointHistory.setMeasurementValue(10.5);
		pointHistory.setMeasurementYear(testDate);
		pointHistory.setId(1);
		
		Mockito.when(pointsRepository.getPointByLocationTime(pointDto.getMeasurementLocation().toString(), pointDto.getMeasurementYear())).thenReturn(null);
		Mockito.when(pointsRepository.save(Mockito.any(Point.class))).thenReturn(point);
		Mockito.when(pointsHistoryRepository.save(Mockito.any(PointHistory.class))).thenReturn(pointHistory);

		Point mockResult = pointsService.savePoint(pointDto);
		
		Assert.assertEquals(mockResult, point);
	}
	
	@Test
	public void testPointSummary() throws ApplicationException {
		//TODO: add the test case after changing it to repository call
		Assert.assertEquals(1, 1);
	}
	
}
