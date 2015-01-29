package com.epam.ecsvparser.service.dal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmployeeDto updateEmployee() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteEmployee(String employeeId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public EmployeeDto getEmployee(String employeeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<EmployeeDto> getEmployees() {
		// TODO Auto-generated method stub
		return null;
	}
}
