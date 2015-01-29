package com.epam.ecsvparser.service.transformer;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import com.epam.ecsvparser.service.domain.EmployeeDto;

public class EmployeeFieldSetMapper implements FieldSetMapper<EmployeeDto> {

	@Override
	public EmployeeDto mapFieldSet(FieldSet fieldSet) throws BindException {
		EmployeeDto employeeDto = new EmployeeDto();
		employeeDto.setFirstName(fieldSet.readString(0));
		employeeDto.setLastName(fieldSet.readString(1));
		employeeDto.setSalary(fieldSet.readInt(2));
		
		return employeeDto;
	}

}
