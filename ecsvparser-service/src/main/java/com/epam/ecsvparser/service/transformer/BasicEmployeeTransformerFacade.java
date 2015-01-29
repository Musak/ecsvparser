package com.epam.ecsvparser.service.transformer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.epam.ecsvparser.repository.Employee;
import com.epam.ecsvparser.service.domain.EmployeeDto;

@Component
public class BasicEmployeeTransformerFacade implements EmployeeTransformerFacade {

	private EmployeeDtoToEmployeeTransformer employeeDtoToEmployeeTransformer;
	private EmployeeToEmployeeDtoTransformer employeeToEmployeeDtoTransformer;
	
	@Autowired
	public BasicEmployeeTransformerFacade(
			EmployeeDtoToEmployeeTransformer employeeDtoToEmployeeTransformer,
			EmployeeToEmployeeDtoTransformer employeeToEmployeeDtoTransformer) {
		this.employeeDtoToEmployeeTransformer = employeeDtoToEmployeeTransformer;
		this.employeeToEmployeeDtoTransformer = employeeToEmployeeDtoTransformer;
	}

	@Override
	public Employee toEmployee(EmployeeDto employeeDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmployeeDto fromEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Employee> toEmployees(Iterable<EmployeeDto> employeeDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<EmployeeDto> fromEmployees(Iterable<Employee> employees) {
		// TODO Auto-generated method stub
		return null;
	}

}
