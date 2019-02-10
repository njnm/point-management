package com.spring.pointmanagement;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.spring.pointmanagement.controllers.PointsController;
import com.spring.pointmanagement.models.Point;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PointManagementApplicationTests {
	
	@Autowired
	   private MockMvc mvc;

	   @MockBean
	   private PointsController pointsController;


//	@Test
//	public void getArrivals() throws Exception {
//		Point point = new Point();
//		point.setMeasurementLocation("FI");
//		point.setMeasurementValue(10.0);
//		//point.setMeasurementYear(Date.)("10-10-2010"));
//
//		List<Point> allPoints = new ArrayList<>();
//		allPoints.add(point);
//
//		given(pointsController.listPoints()).willReturn(allPoints);
//
//		mvc.perform(
//				get(VERSION + ARRIVAL + "all").with(user("blaze").password("Q1w2e3r4")).contentType(APPLICATION_JSON))
//				.andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(1)))
//				.andExpect(jsonPath("$[0].city", is(arrival.getCity())));
//	}

}
