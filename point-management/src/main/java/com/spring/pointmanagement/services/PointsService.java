package com.spring.pointmanagement.services;

import java.util.List;

import com.spring.pointmanagement.exceptions.ApplicationException;
import com.spring.pointmanagement.models.Point;
import com.spring.pointmanagement.models.PointDto;

public interface PointsService {

	public List<Point> getPoints() throws ApplicationException;
	
	public Point savePoint(PointDto point) throws ApplicationException;
	
	public boolean deletePoint(Integer id) throws ApplicationException;
}
