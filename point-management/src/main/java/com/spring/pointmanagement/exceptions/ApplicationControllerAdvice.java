package com.spring.pointmanagement.exceptions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.spring.pointmanagement.controllers.PointsController;

@ControllerAdvice
public class ApplicationControllerAdvice extends ResponseEntityExceptionHandler {
	
	private static final Logger logger = LogManager.getLogger(PointsController.class);
	
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		logger.error(ex.getCause());
		return buildResponseEntity(new ApiError(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST, new Throwable(ex.getCause())));
	}
	
	@ExceptionHandler(ApplicationException.class)
	protected ResponseEntity<Object> handleApplicationException(ApplicationException ex) {
		logger.error(ex.getCause());
		return buildResponseEntity(new ApiError(HttpStatus.INTERNAL_SERVER_ERROR.value(),HttpStatus.INTERNAL_SERVER_ERROR, ex));
	}
	
	@ExceptionHandler(BadRequestException.class)
	protected ResponseEntity<Object> handleBadRequestException(BadRequestException ex) {
		logger.error(ex.getCause());
		return buildResponseEntity(new ApiError(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST, ex));
	}

	private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
		return new ResponseEntity<>(apiError, apiError.getStatus());
	}
}
