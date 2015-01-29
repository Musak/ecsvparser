package com.epam.ecsvparser.service;

import com.epam.ecsvparser.service.domain.EmployeeDto;

public interface EmployeeService {
	EmployeeDto createEmployee();

	EmployeeDto updateEmployee();

	void deleteEmployee(String employeeId);

	EmployeeDto getEmployee(String employeeId);

	Iterable<EmployeeDto> getEmployees();
}
