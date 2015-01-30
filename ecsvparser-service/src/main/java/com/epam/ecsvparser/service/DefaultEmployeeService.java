package com.epam.ecsvparser.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.ecsvparser.service.dal.EmployeeDao;
import com.epam.ecsvparser.service.domain.EmployeeDto;

@Service
@Transactional
public class DefaultEmployeeService implements EmployeeService {

	private EmployeeDao employeeDao;

	@Autowired
	public DefaultEmployeeService(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {
		return employeeDao.createEmployee(employeeDto);
	}

	@Override
	public EmployeeDto updateEmployee(EmployeeDto employeeDto) {
		return employeeDao.updateEmployee(employeeDto);
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
