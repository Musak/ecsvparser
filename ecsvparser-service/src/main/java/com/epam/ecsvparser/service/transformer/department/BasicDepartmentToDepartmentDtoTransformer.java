package com.epam.ecsvparser.service.transformer.department;

import org.springframework.stereotype.Component;

import com.epam.ecsvparser.repository.deparment.Department;
import com.epam.ecsvparser.service.domain.DepartmentDto;

@Component
public class BasicDepartmentToDepartmentDtoTransformer implements
		DepartmentToDepartmentDtoTransformer {
	
	@Override
	public DepartmentDto transform(Department department) {
		DepartmentDto departmentDto = new DepartmentDto();
		departmentDto.setAverage(department.getAverage());
		departmentDto.setDepartmentId(department.getDepartmentId());
		departmentDto.setName(department.getName());
		return departmentDto;
	}

}
