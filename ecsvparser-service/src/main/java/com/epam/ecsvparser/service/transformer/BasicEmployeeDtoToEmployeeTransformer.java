package com.epam.ecsvparser.service.transformer;

import org.springframework.stereotype.Component;

import com.epam.ecsvparser.repository.Employee;
import com.epam.ecsvparser.service.domain.EmployeeDto;

@Component
public class BasicEmployeeDtoToEmployeeTransformer implements
		EmployeeDtoToEmployeeTransformer {

	@Override
	public EmployeeDto transform(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

}
