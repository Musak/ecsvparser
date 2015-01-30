package com.epam.ecsvparser.service;

import com.epam.ecsvparser.service.domain.EmployeeDto;

public interface EmployeeService {
	EmployeeDto createEmployee(EmployeeDto employeeDto);

	EmployeeDto updateEmployee(EmployeeDto employeeDto);

	void deleteEmployee(String employeeId);

	EmployeeDto getEmployee(String employeeId);

	Iterable<EmployeeDto> getEmployees();
}
