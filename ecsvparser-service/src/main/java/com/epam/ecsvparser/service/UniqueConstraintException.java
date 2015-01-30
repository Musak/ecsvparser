package com.epam.ecsvparser.service;

public class UniqueConstraintException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public UniqueConstraintException(String message) {
		super(message);
	}
}
