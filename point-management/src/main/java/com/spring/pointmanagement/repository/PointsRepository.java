package com.spring.pointmanagement.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.pointmanagement.models.Point;

@Repository
public interface PointsRepository extends CrudRepository<Point, Integer>{

	@Query(value="SELECT * FROM POINTS WHERE MEASUREMENT_LOCATION = :location", nativeQuery = true)
	public List<Point> getPointByMeasurementLocation(@Param("location") String location);
	
	@Query(value="SELECT ID, MEASUREMENT_VALUE, MEASUREMENT_LOCATION, MEASUREMENT_YEAR FROM POINTS P WHERE MEASUREMENT_LOCATION = :measurementLocation AND MEASUREMENT_YEAR = :measurementYear", nativeQuery = true)
	public Point getPointByLocationTime(@Param("measurementLocation") String locationTypes, @Param("measurementYear") Date measurementYear);
	
	@Query(value="SELECT round(MIN(MEASUREMENT_VALUE)) AS minValue, round(MAX(MEASUREMENT_VALUE)) AS maxVal, round(SUM(MEASUREMENT_VALUE), 2) AS sumValue, round(AVG(MEASUREMENT_VALUE)) AS avgValue FROM POINTS", nativeQuery = true)
	public Object[] getPointSummary();
	
}
