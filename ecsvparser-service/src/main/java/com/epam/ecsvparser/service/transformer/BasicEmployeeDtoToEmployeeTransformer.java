package com.epam.ecsvparser.service.transformer;

import org.springframework.stereotype.Component;

import com.epam.ecsvparser.repository.Employee;
import com.epam.ecsvparser.service.domain.EmployeeDto;

@Component
public class BasicEmployeeDtoToEmployeeTransformer implements
		EmployeeDtoToEmployeeTransformer {

	@Override
	public Employee transform(EmployeeDto employeeDto) {
		Employee employee = new Employee();
		employee.setFirstName(employeeDto.getFirstName());
		employee.setLastName(employeeDto.getLastName());
		employee.setSalary(employeeDto.getSalary());
		employee.setCreationTime(employeeDto.getCreationTime());
		employee.setEmployeeId(employeeDto.getEmployeeId());
		return employee;
	}

}
