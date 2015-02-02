package com.epam.ecsvparser.service.dal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.epam.ecsvparser.repository.employee.Employee;
import com.epam.ecsvparser.repository.employee.EmployeeRepository;
import com.epam.ecsvparser.service.UniqueConstraintException;
import com.epam.ecsvparser.service.domain.EmployeeDto;
import com.epam.ecsvparser.service.transformer.employee.EmployeeTransformerFacade;

@Component
public class DefaultEmployeeDao implements EmployeeDao {
	
	private final EmployeeRepository employeeRepository;
	private final EmployeeTransformerFacade employeeTransformerFacade;
	
	@Autowired
	public DefaultEmployeeDao(EmployeeRepository employeeRepository,
			EmployeeTransformerFacade employeeTransformerFacade) {
		this.employeeRepository = employeeRepository;
		this.employeeTransformerFacade = employeeTransformerFacade;
	}

	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {
		Assert.notNull(employeeDto);
		checkEmployeeAlreadyExists(employeeDto);
		
		Employee employee = employeeRepository.save(employeeTransformerFacade.toEmployee(employeeDto));
		return employeeTransformerFacade.fromEmployee(employee);
	}

	@Override
	public EmployeeDto updateEmployee(EmployeeDto employeeDto) {
		Assert.notNull(employeeDto);
		checkEmployeeAlreadyExists(employeeDto);
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

	private void checkEmployeeAlreadyExists(EmployeeDto employeeDto) {
		Employee employeeDB = employeeRepository.findByFirstNameAndLastName(employeeDto.getFirstName(), employeeDto.getLastName());
		if(employeeDB != null) {
			throw new UniqueConstraintException("Employee with name: " + employeeDto.getFirstName() + " " + employeeDto.getLastName());
		}
	}

}
