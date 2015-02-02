package com.epam.ecsvparser.service.transformer.employee;

import com.epam.ecsvparser.repository.employee.Employee;
import com.epam.ecsvparser.service.domain.EmployeeDto;

public interface EmployeeTransformerFacade {
	Employee toEmployee(EmployeeDto employeeDto);
	
	EmployeeDto fromEmployee(Employee employee);
	
	Iterable<Employee> toEmployees(Iterable<EmployeeDto> employeeDto);
	
	Iterable<EmployeeDto> fromEmployees(Iterable<Employee> employees);
}
