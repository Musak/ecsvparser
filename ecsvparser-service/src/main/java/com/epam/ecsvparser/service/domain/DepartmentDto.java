package com.epam.ecsvparser.service.domain;

import java.util.Collection;
import java.util.HashSet;

public class DepartmentDto {
	
	private String departmentId;
	
	private String name;
	
	private Double average;
	
	private Iterable<EmployeeDto> employees = new HashSet<EmployeeDto>();

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getAverage() {
		return average;
	}

	public void setAverage(Double average) {
		this.average = average;
	}

	public Collection<EmployeeDto> getEmployees() {
		return (Collection<EmployeeDto>) employees;
	}

	public void setEmployees(Iterable<EmployeeDto> employees) {
		this.employees = employees;
	}
}
