package com.epam.ecsvparser.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.epam.ecsvparser.service.domain.EmployeeDto;

@Service
@Transactional
public class DefaultEmployeeService implements EmployeeService {

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
