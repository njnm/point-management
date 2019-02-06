package com.spring.pointmanagement.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.pointmanagement.models.Point;

@Repository
public interface PointsRepository extends CrudRepository<Point, Integer>{

	@Query(value="SELECT ID, MEASUREMENT_VALUE, MEASUREMENT_LOCATION, MEASUREMENT_YEAR FROM POINTS P WHERE MEASUREMENT_LOCATION = :measurementLocation AND MEASUREMENT_YEAR = :measurementYear", nativeQuery = true)
	public Point getPointByLocationTime(@Param("measurementLocation") String measurementLocation, @Param("measurementYear") Date measurementYear);
	
}
