package com.spring.pointmanagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.pointmanagement.exceptions.ApplicationException;
import com.spring.pointmanagement.models.Point;
import com.spring.pointmanagement.models.PointDto;
import com.spring.pointmanagement.models.ResponseObject;
import com.spring.pointmanagement.services.PointsService;

@RestController()
@CrossOrigin
@RequestMapping("/points")
public class PointsController {
	
	@Autowired
	private PointsService pointsService;
	
    @GetMapping
    public ResponseObject<List<PointDto>> listPoints() throws ApplicationException{
        return new ResponseObject<List<PointDto>>(HttpStatus.OK.value(), "Points list fetched successfully.",pointsService.getPoints());
    }
    
    @PostMapping
    public ResponseObject<Point> savePoint(@RequestBody PointDto point) throws ApplicationException{
        return new ResponseObject<Point>(HttpStatus.OK.value(), "Points saved successfully.", pointsService.savePoint(point));
    }
    
    @DeleteMapping
    public ResponseObject<Void> deletePoint(@RequestParam("id") Integer id) throws ApplicationException{
    	pointsService.deletePoint(id);
        return new ResponseObject<Void>(HttpStatus.OK.value(), "Point deleted successfully.", null);
    }

}
