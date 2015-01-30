package com.epam.ecsvparser.service.transformer.employee;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
		return employeeDtoToEmployeeTransformer.transform(employeeDto);
	}

	@Override
	public EmployeeDto fromEmployee(Employee employee) {
		employeeToEmployeeDtoTransformer.transform(employee);
		return null;
	}

	@Override
	public Iterable<Employee> toEmployees(Iterable<EmployeeDto> employeeDto) {
		Iterator<EmployeeDto> iterator = employeeDto.iterator();
		List<Employee> employees = new ArrayList<Employee>();
		while (iterator.hasNext()) {
			employees.add(this.toEmployee(iterator.next()));
		}
		return employees;
	}

	@Override
	public Iterable<EmployeeDto> fromEmployees(Iterable<Employee> employees) {
		Iterator<Employee> iterator = employees.iterator();
		List<EmployeeDto> employeesDto = new ArrayList<EmployeeDto>();
		while (iterator.hasNext()) {
			employeesDto.add(this.fromEmployee(iterator.next()));
		}
		return employeesDto;
	}

}
