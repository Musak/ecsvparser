package com.epam.ecsvparser.service.transformer.department;

import org.springframework.stereotype.Component;

import com.epam.ecsvparser.repository.Department;
import com.epam.ecsvparser.service.domain.DepartmentDto;

@Component
public class BasicDepartmentDtoToDepartmentTransformer implements
		DepartmentDtoToDepartmentTransformer {

	@Override
	public Department transform(DepartmentDto departmentDto) {
		Department department = new Department(); 
		department.setName(departmentDto.getName());
		department.setDepartmentId(departmentDto.getDepartmentId());
		department.setAverage(departmentDto.getAverage());
		
		return department;
	}

}
