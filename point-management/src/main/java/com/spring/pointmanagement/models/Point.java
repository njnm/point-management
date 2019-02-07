package com.spring.pointmanagement.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.spring.pointmanagement.enums.LocationTypes;

@Entity
@Table(name = "POINTS")
public class Point {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "measurement_value")
	private Double measurementValue;

	@Column(name = "measurement_location")
	private LocationTypes measurementLocation;

	@Column(name = "measurement_year")
	private Date measurementYear;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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
