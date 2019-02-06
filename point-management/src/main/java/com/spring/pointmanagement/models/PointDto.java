package com.spring.pointmanagement.models;

import java.util.Date;

import com.spring.pointmanagement.enums.LocationTypes;

public class PointDto {

	private String measurementValue;

	private LocationTypes measurementLocation;

	private Date measurementYear;

	public String getMeasurementValue() {
		return measurementValue;
	}

	public void setMeasurementValue(String measurementValue) {
		this.measurementValue = measurementValue;
	}

	public LocationTypes getMeasurementLocation() {
		return measurementLocation;
	}

	public void setMeasurementLocation(LocationTypes measurementLocation) {
		this.measurementLocation = measurementLocation;
	}

	public Date getMeasurementYear() {
		return measurementYear;
	}

	public void setMeasurementYear(Date measurementYear) {
		this.measurementYear = measurementYear;
	}

}
