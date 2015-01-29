package com.epam.ecsvparser.service.dal;

import com.epam.ecsvparser.service.domain.EmployeeDto;

public interface EmployeeDao {
	EmployeeDto createEmployee();
	
	EmployeeDto updateEmployee();
	
	void deleteEmployee(String employeeId);
	
	EmployeeDto getEmployee(String employeeId);
	
	Iterable<EmployeeDto> getEmployees();
	
}
