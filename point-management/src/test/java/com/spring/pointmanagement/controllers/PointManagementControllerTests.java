package com.spring.pointmanagement.controllers;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.spring.pointmanagement.AbstractTests;
import com.spring.pointmanagement.models.Point;

public class PointManagementControllerTests extends AbstractTests {

	@Override
	@Before
	public void setUp() {
		super.setUp();
	}
	
	@Test
	public void createPoints() throws Exception {
		String uri = "/points";
		Point point = new Point();
		point.setMeasurementLocation("EE");
		point.setMeasurementValue(100.0);
		point.setMeasurementYear(new Date());
		String inputJson = super.mapToJson(point);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertTrue(200 == status);
	}
	
	@Test
	public void createPointsError() throws Exception {
		String uri = "/points";
		Point point = new Point();
		//setting an invalid location code should result in bad request
		point.setMeasurementLocation("EI");
		point.setMeasurementValue(100.0);
		point.setMeasurementYear(new Date());
		String inputJson = super.mapToJson(point);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertTrue(400 == status);
	}

	@Test
	public void getPointsList() throws Exception {
		String uri = "/points/EE";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertTrue(status == 200);
	}
}
