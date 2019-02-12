package com.spring.pointmanagement.controllers;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.pointmanagement.PointManagementApplication;
import com.spring.pointmanagement.enums.LocationTypes;
import com.spring.pointmanagement.exceptions.ApplicationException;
import com.spring.pointmanagement.exceptions.BadRequestException;
import com.spring.pointmanagement.models.Point;
import com.spring.pointmanagement.models.PointDto;
import com.spring.pointmanagement.models.ResponseObject;
import com.spring.pointmanagement.services.PointsService;

@RestController()
@CrossOrigin
@RequestMapping("/points")
public class PointsController {
	
	private static final Logger logger = LogManager.getLogger(PointsController.class);
	
	@Autowired
	private PointsService pointsService;
	
    @GetMapping
    public ResponseObject<List<PointDto>> listPoints() throws ApplicationException{
    	logger.info("List All Points");
    	List<Point> points = pointsService.getPoints();
    	if(points.size() > 0) {
            return new ResponseObject<List<PointDto>>(HttpStatus.OK.value(), "Points list fetched successfully.",points);
    	}else {
    		return new ResponseObject<List<PointDto>>(HttpStatus.NOT_FOUND.value(), "Points not found",points);
    	}
    }
    
    @GetMapping("/{location}")
    public ResponseObject<List<PointDto>> listPointByLocation(@PathVariable("location") LocationTypes location) throws ApplicationException{
    	logger.info("List All Points for " + location);
    	List<Point> points = pointsService.getPointsByLocation(location);
    	if(points.size() > 0) {
            return new ResponseObject<List<PointDto>>(HttpStatus.OK.value(), "Points list fetched successfully.",points);
    	}else {
    		return new ResponseObject<List<PointDto>>(HttpStatus.NOT_FOUND.value(), "Points not found.",points);
    	}
    }
    
    @PostMapping
    public ResponseObject<Point> savePoint(@Valid @RequestBody PointDto point, BindingResult result) throws ApplicationException{
    	if(result.hasErrors()) {
    		throw new BadRequestException(result.getFieldErrors().get(0).getDefaultMessage());
    	}
    	logger.info("Save point for  " + point.getMeasurementLocation());
        return new ResponseObject<Point>(HttpStatus.OK.value(), "Points saved successfully.", pointsService.savePoint(point));
    }
    
    @DeleteMapping
    public ResponseObject<Void> deletePoint(@RequestParam("id") Integer id) throws ApplicationException{
    	logger.info("Delete point for  " + id);
    	pointsService.deletePoint(id);
        return new ResponseObject<Void>(HttpStatus.OK.value(), "Point deleted successfully.", null);
    }

}
