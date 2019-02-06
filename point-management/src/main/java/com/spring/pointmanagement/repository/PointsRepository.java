package com.spring.pointmanagement.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.pointmanagement.models.Point;

@Repository
public interface PointsRepository extends CrudRepository<Point, Integer>{

}
