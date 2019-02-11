package com.spring.pointmanagement.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

class ApiError {

	private int statusCode;
	private HttpStatus status;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private LocalDateTime timestamp;
	private String message;

	private ApiError() {
		timestamp = LocalDateTime.now();
	}

	ApiError(HttpStatus status) {
		this();
		this.setStatus(status);
	}

	ApiError(HttpStatus status, Throwable ex) {
		this();
		this.setStatus(status);
		this.setMessage(ex.getMessage());
	}

	ApiError(int statusCode, HttpStatus status, Throwable ex) {
		this();
		this.setStatus(status);
		this.setMessage(ex.getMessage());
		this.setStatusCode(statusCode);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

}
