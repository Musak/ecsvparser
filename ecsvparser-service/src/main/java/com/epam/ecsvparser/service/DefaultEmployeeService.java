package com.epam.ecsvparser.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.epam.ecsvparser.service.dal.EmployeeDao;
import com.epam.ecsvparser.service.domain.EmployeeDto;

@Service
@Transactional
public class DefaultEmployeeService implements EmployeeService {

	private EmployeeDao employeeDao;
	
	@Override
	public EmployeeDto createEmployee() {
		return employeeDao.createEmployee();
	}

	@Override
	public EmployeeDto updateEmployee() {
		return employeeDao.updateEmployee();
	}

	@Override
	public void deleteEmployee(String employeeId) {
		employeeDao.deleteEmployee(employeeId);
	}

	@Override
	public EmployeeDto getEmployee(String employeeId) {
		return employeeDao.getEmployee(employeeId);
	}

	@Override
	public Iterable<EmployeeDto> getEmployees() {
		return employeeDao.getEmployees();
	}

}
