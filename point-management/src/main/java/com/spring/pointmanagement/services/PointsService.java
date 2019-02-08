package com.spring.pointmanagement.services;

import java.sql.SQLDataException;
import java.util.List;

import com.spring.pointmanagement.enums.LocationTypes;
import com.spring.pointmanagement.exceptions.ApplicationException;
import com.spring.pointmanagement.models.Point;
import com.spring.pointmanagement.models.PointDto;
import com.spring.pointmanagement.models.PointSummary;

public interface PointsService {

	public List<Point> getPoints() throws ApplicationException;
	
	public List<Point> getPointsByLocation(LocationTypes location) throws ApplicationException;
	
	public Point savePoint(PointDto point) throws ApplicationException;
	
	public boolean deletePoint(Integer id) throws ApplicationException;
	
	public PointSummary getPointSummary() throws ApplicationException;
}
