package com.spring.pointmanagement.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.spring.pointmanagement.enums.LocationTypes;
import com.spring.pointmanagement.exceptions.ApplicationException;
import com.spring.pointmanagement.models.Point;
import com.spring.pointmanagement.models.PointDto;
import com.spring.pointmanagement.models.PointSummary;
import com.spring.pointmanagement.repository.PointsRepository;
import com.spring.pointmanagement.services.PointsService;

@Service
public class PointsServiceImpl implements PointsService{
	
	@Autowired
	private PointsRepository pointsRepository;

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
			point.setMeasurementValue(pointDto.getMeasurementValue());
			point.setMeasurementYear(pointDto.getMeasurementYear());
			return pointsRepository.save(point);
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
			Object[] obj = pointsRepository.getPointSummary();
			
			PointSummary point = new PointSummary();
//			point.setMinVal((Double) obj[0]);
//			point.setMaxVal((Double) obj[1]);
//			point.setSumVal((Double) obj[2]);
//			point.setAvgVal((Double) obj[3]);
			return point;
		}catch (Exception e) {
			throw new ApplicationException("Something went wrong.Please try again");
		}
	}

}
