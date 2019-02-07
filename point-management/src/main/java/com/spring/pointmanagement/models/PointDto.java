package com.spring.pointmanagement.models;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import com.spring.pointmanagement.enums.LocationTypes;

public class PointDto {

	@NotNull(message = "Measurement Value cannot be null")
	private Double measurementValue;

	@NotNull(message = "Measrurement Location cannot be null")
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
