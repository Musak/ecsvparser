package com.epam.ecsvparser.service.transformer.employee;

import com.epam.ecsvparser.repository.employee.Employee;
import com.epam.ecsvparser.service.domain.EmployeeDto;

public interface EmployeeToEmployeeDtoTransformer {
	EmployeeDto transform(Employee employee);
}
