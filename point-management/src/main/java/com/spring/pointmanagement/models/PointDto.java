package com.spring.pointmanagement.models;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import com.spring.pointmanagement.enums.LocationTypes;

public class PointDto {

 	@NotNull(message = "Measurement Value cannot be null")
	@Min(message="Measuremnt value cannot be less than 1", value = 1)
	@Max(message="Measuremnt value cannot be greater than 1000", value = 1000)
 	private Double measurementValue;
 
	@NotNull(message = "Measurement Location cannot be null")
 	private LocationTypes measurementLocation;

	@PastOrPresent(message="Measurement Date cannot be in the future")
	private Date measurementYear;

	public Double getMeasurementValue() {
		return measurementValue;
	}

	public void setMeasurementValue(Double measurementValue) {
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
