package com.epam.ecsvparser.service.transformer;

import org.springframework.stereotype.Component;

import com.epam.ecsvparser.repository.Employee;
import com.epam.ecsvparser.service.domain.EmployeeDto;

@Component
public class BasicEmployeeToEmployeeDtoTransformer implements EmployeeToEmployeeDtoTransformer {

	@Override
	public EmployeeDto transform(Employee employee) {
		EmployeeDto employeeDto = new EmployeeDto();
		employeeDto.setEmployeeId(employee.getEmployeeId());
		employeeDto.setFirstName(employee.getFirstName());
		employeeDto.setLastName(employee.getLastName());
		employeeDto.setCreationTime(employee.getCreationTime());
		employeeDto.setSalary(employee.getSalary());
		return employeeDto;
	}

}
