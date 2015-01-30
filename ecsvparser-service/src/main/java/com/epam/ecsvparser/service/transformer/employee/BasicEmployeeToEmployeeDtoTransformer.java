package com.epam.ecsvparser.service.transformer.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.epam.ecsvparser.repository.Employee;
import com.epam.ecsvparser.service.domain.DepartmentDto;
import com.epam.ecsvparser.service.domain.EmployeeDto;
import com.epam.ecsvparser.service.transformer.department.DepartmentTransformerFacade;

@Component
public class BasicEmployeeToEmployeeDtoTransformer implements EmployeeToEmployeeDtoTransformer {

	private DepartmentTransformerFacade departmentTransformerFacade;
	
	@Autowired
	public BasicEmployeeToEmployeeDtoTransformer(
			DepartmentTransformerFacade departmentTransformerFacade) {
		this.departmentTransformerFacade = departmentTransformerFacade;
	}

	@Override
	public EmployeeDto transform(Employee employee) {
		EmployeeDto employeeDto = new EmployeeDto();
		employeeDto.setEmployeeId(employee.getEmployeeId());
		employeeDto.setFirstName(employee.getFirstName());
		employeeDto.setLastName(employee.getLastName());
		employeeDto.setSalary(employee.getSalary());
		
		DepartmentDto departmentDto = departmentTransformerFacade.fromDepartment(employee.getDepartment());
		employeeDto.setDepartmentDto(departmentDto);
		return employeeDto;
	}

}
