package com.epam.ecsvparser.service.dal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.epam.ecsvparser.repository.Employee;
import com.epam.ecsvparser.repository.EmployeeRepository;
import com.epam.ecsvparser.service.domain.EmployeeDto;
import com.epam.ecsvparser.service.transformer.EmployeeTransformerFacade;

@Component
public class DefaultEmployeeDao implements EmployeeDao {

	private EmployeeRepository employeeRepository;
	private EmployeeTransformerFacade employeeTransformerFacade;
	
	@Autowired
	public DefaultEmployeeDao(EmployeeRepository employeeRepository,
			EmployeeTransformerFacade employeeTransformerFacade) {
		this.employeeRepository = employeeRepository;
		this.employeeTransformerFacade = employeeTransformerFacade;
	}

	@Override
	public EmployeeDto createEmployee() {
		
		return null;
	}

	@Override
	public EmployeeDto updateEmployee() {
		
		return null;
	}

	@Override
	public void deleteEmployee(String employeeId) {
		employeeRepository.delete(employeeId);		
	}

	@Override
	public EmployeeDto getEmployee(String employeeId) {
		Employee employee = employeeRepository.findOne(employeeId);
		EmployeeDto employeeDto = employeeTransformerFacade.fromEmployee(employee);
		return employeeDto;
	}

	@Override
	public Iterable<EmployeeDto> getEmployees() {
		Iterable<Employee> employees = employeeRepository.findAll();
		Iterable<EmployeeDto> employeesDto = employeeTransformerFacade.fromEmployees(employees);
		return employeesDto;
	}
}
