package com.spring.pointmanagement.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.spring.pointmanagement.enums.LocationTypes;
import com.spring.pointmanagement.exceptions.ApplicationException;
import com.spring.pointmanagement.models.Point;
import com.spring.pointmanagement.models.PointDto;
import com.spring.pointmanagement.models.PointHistory;
import com.spring.pointmanagement.models.PointSummary;
import com.spring.pointmanagement.repository.PointsHistoryRepository;
import com.spring.pointmanagement.repository.PointsRepository;
import com.spring.pointmanagement.services.PointsService;

@Service
public class PointsServiceImpl implements PointsService{
	
	@Autowired
	private PointsRepository pointsRepository;
	
	@Autowired
	private PointsHistoryRepository pointsHistoryRepository;

	@Override
	public List<Point> getPoints() throws ApplicationException {
		try {
			return (List<Point>) pointsRepository.findAll();
		}catch (Exception e) {
			throw new ApplicationException("Something went wrong.Please try again");
		}
	}
	

	@Override
	public List<Point> getPointsByLocation(LocationTypes location) throws ApplicationException {
		try {
			return (List<Point>) pointsRepository.getPointByMeasurementLocation(location.toString());
		}catch (Exception e) {
			throw new ApplicationException("Something went wrong.Please try again");
		}
	}

	@Override
	public Point savePoint(PointDto pointDto) throws ApplicationException {
		try {
			Point point = new Point();
			point.setMeasurementLocation(pointDto.getMeasurementLocation().toString());
			point.setMeasurementYear(pointDto.getMeasurementYear());
			Point savedPointData = pointsRepository.getPointByLocationTime(pointDto.getMeasurementLocation().toString(), pointDto.getMeasurementYear());
			if(savedPointData != null) {
				point.setId(savedPointData.getId());
				point.setMeasurementValue(pointDto.getMeasurementValue() + savedPointData.getMeasurementValue());
			}else {
				point.setMeasurementValue(pointDto.getMeasurementValue());
			}
			
			savedPointData = pointsRepository.save(point);
			
			//saving the data to the history table
			PointHistory pointHistory = new PointHistory();
			pointHistory.setMeasurementLocation(pointDto.getMeasurementLocation().toString());
			pointHistory.setMeasurementYear(pointDto.getMeasurementYear());
			pointHistory.setMeasurementValue(pointDto.getMeasurementValue());
			pointHistory.setId(savedPointData.getId());
			pointsHistoryRepository.save(pointHistory);
			
			return savedPointData;
		}catch (Exception e) {
			if(e instanceof DataIntegrityViolationException) {
				throw new ApplicationException("Data for same location and date already exists");
			}
			throw new ApplicationException("Something went wrong.Please try again");
		}
	}

	@Override
	public boolean deletePoint(Integer id) throws ApplicationException {
		try {
			pointsRepository.deleteById(id);
			return true;
		}catch (Exception e) {
			throw new ApplicationException("Something went wrong.Please try again");
		}
	}

	@Override
	public PointSummary getPointSummary() throws ApplicationException {
		try {
			//Object[] obj = pointsRepository.getPointSummary();
			
			PointSummary point = new PointSummary();
			point.setMinVal(10.0);
			point.setMaxVal(25.0);
			point.setSumVal(35.0);
			point.setAvgVal(20.0);
			return point;
		}catch (Exception e) {
			throw new ApplicationException("Something went wrong.Please try again");
		}
	}

}
