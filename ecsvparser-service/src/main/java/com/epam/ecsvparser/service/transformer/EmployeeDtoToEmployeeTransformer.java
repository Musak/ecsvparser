package com.epam.ecsvparser.service.transformer;

import com.epam.ecsvparser.repository.Employee;
import com.epam.ecsvparser.service.domain.EmployeeDto;

public interface EmployeeDtoToEmployeeTransformer {
	EmployeeDto transform(Employee employee);
}
