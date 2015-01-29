package com.epam.ecsvparser.service.transformer;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;

import com.epam.ecsvparser.service.domain.EmployeeDto;

@Component
public class EmployeeFieldSetMapper implements FieldSetMapper<EmployeeDto> {

	@Override
	public EmployeeDto mapFieldSet(FieldSet fieldSet) throws BindException {
		EmployeeDto employeeDto = new EmployeeDto();
		// TODO prepopulate fields
		return employeeDto;
	}

}
