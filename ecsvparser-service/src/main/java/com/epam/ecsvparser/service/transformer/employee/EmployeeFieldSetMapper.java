package com.epam.ecsvparser.service.transformer.employee;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;

import com.epam.ecsvparser.service.DepartmentService;
import com.epam.ecsvparser.service.domain.DepartmentDto;
import com.epam.ecsvparser.service.domain.EmployeeDto;

@Component
public class EmployeeFieldSetMapper implements FieldSetMapper<EmployeeDto> {

	private DepartmentService departmentService;
	
	@Autowired
	public EmployeeFieldSetMapper(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	@Override
	public EmployeeDto mapFieldSet(FieldSet fieldSet) throws BindException {
		EmployeeDto employeeDto = new EmployeeDto();
		employeeDto.setFirstName(fieldSet.readString(0));
		employeeDto.setLastName(fieldSet.readString(1));
		
		String departmentName = fieldSet.readString(2);
		DepartmentDto departmentByName = departmentService.getDepartmentByName(departmentName);
		employeeDto.setDepartmentDto(departmentByName);
		employeeDto.setSalary(fieldSet.readInt(3));
		return employeeDto;
	}

}
