package com.spring.pointmanagement.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.pointmanagement.models.PointHistory;

@Repository
public interface PointsHistoryRepository extends CrudRepository<PointHistory, Integer>{
	
}
