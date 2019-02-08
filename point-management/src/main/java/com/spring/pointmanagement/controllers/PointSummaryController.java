package com.spring.pointmanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.pointmanagement.exceptions.ApplicationException;
import com.spring.pointmanagement.models.PointSummary;
import com.spring.pointmanagement.models.ResponseObject;
import com.spring.pointmanagement.services.PointsService;

@RestController()
@CrossOrigin
@RequestMapping("/summary")
public class PointSummaryController {

	@Autowired
	private PointsService pointsService;
	
    @GetMapping
    public ResponseObject<PointSummary> getPointSummary() throws ApplicationException{
        return new ResponseObject<PointSummary>(HttpStatus.OK.value(), "Points sumamry fetched successfully.",pointsService.getPointSummary());
    }
	
}
