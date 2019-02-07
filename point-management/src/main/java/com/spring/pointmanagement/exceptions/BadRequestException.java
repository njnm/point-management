package com.spring.pointmanagement.exceptions;

public class BadRequestException extends IllegalArgumentException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public BadRequestException(String message) {
		super(message);
	}

}
