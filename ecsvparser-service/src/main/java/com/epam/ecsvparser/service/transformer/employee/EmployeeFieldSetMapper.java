package com.epam.ecsvparser.service.transformer.employee;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;

import com.epam.ecsvparser.service.dal.DepartmentDao;
import com.epam.ecsvparser.service.domain.DepartmentDto;
import com.epam.ecsvparser.service.domain.EmployeeDto;

@Component
public class EmployeeFieldSetMapper implements FieldSetMapper<EmployeeDto> {

	// TODO implement DepartmentService
	private DepartmentDao departmentDao;
	
	@Autowired
	public EmployeeFieldSetMapper(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}

	@Override
	public EmployeeDto mapFieldSet(FieldSet fieldSet) throws BindException {
		EmployeeDto employeeDto = new EmployeeDto();
		employeeDto.setFirstName(fieldSet.readString(0));
		employeeDto.setLastName(fieldSet.readString(1));
		
		String departmentName = fieldSet.readString(2);
		DepartmentDto departmentByName = departmentDao.getDepartmentByName(departmentName);
		employeeDto.setDepartmentDto(departmentByName);
		employeeDto.setSalary(fieldSet.readInt(3));
		return employeeDto;
	}

}
