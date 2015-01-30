package com.epam.ecsvparser.service.dal;

public class DepartmentNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 8623988770565717464L;
	
	public DepartmentNotFoundException(String message) {
		super(message);
	}

}
