package com.spring.pointmanagement.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.pointmanagement.exceptions.ApplicationException;
import com.spring.pointmanagement.models.Point;
import com.spring.pointmanagement.models.PointDto;
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
	public Point savePoint(PointDto pointDto) throws ApplicationException {
		try {
//			Point savedPoint = pointsRepository.getPointByLocationTime(pointDto.getMeasurementLocation().toString(), pointDto.getMeasurementYear());
			
			Point point = new Point();
			point.setMeasurementLocation(pointDto.getMeasurementLocation());
			point.setMeasurementValue(pointDto.getMeasurementValue());
			point.setMeasurementYear(pointDto.getMeasurementYear());
			return pointsRepository.save(point);
		}catch (Exception e) {
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

}
