package com.epam.ecsvparser.service.transformer.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.epam.ecsvparser.repository.deparment.Department;
import com.epam.ecsvparser.repository.employee.Employee;
import com.epam.ecsvparser.service.domain.EmployeeDto;
import com.epam.ecsvparser.service.transformer.department.DepartmentTransformerFacade;

@Component
public class BasicEmployeeDtoToEmployeeTransformer implements
		EmployeeDtoToEmployeeTransformer {

	@Autowired
	public BasicEmployeeDtoToEmployeeTransformer(
			DepartmentTransformerFacade departmentTransformerFacade) {
		this.departmentTransformerFacade = departmentTransformerFacade;
	}

	private DepartmentTransformerFacade departmentTransformerFacade;
	
	@Override
	public Employee transform(EmployeeDto employeeDto) {
		Employee employee = new Employee();
		employee.setFirstName(employeeDto.getFirstName());
		employee.setLastName(employeeDto.getLastName());
		employee.setSalary(employeeDto.getSalary());
		employee.setEmployeeId(employeeDto.getEmployeeId());
		
		Department department = departmentTransformerFacade.toDepartment(employeeDto.getDepartmentDto());
		employee.setDepartment(department);
		return employee;
	}

}
