package com.epam.ecsvparser.service.transformer;

import org.springframework.stereotype.Component;

import com.epam.ecsvparser.repository.Employee;
import com.epam.ecsvparser.service.domain.EmployeeDto;

@Component
public class BasicEmployeeToEmployeeDtoTransformer implements EmployeeToEmployeeDtoTransformer {

	@Override
	public Employee transform(EmployeeDto employeeDto) {
		// TODO Auto-generated method stub
		return null;
	}

}
