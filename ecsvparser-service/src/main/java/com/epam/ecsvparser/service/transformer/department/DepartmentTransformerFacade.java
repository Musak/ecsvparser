package com.epam.ecsvparser.service.transformer.department;

import com.epam.ecsvparser.repository.Department;
import com.epam.ecsvparser.service.domain.DepartmentDto;

public interface DepartmentTransformerFacade {
	Department toDepartment(DepartmentDto departmentDto);
	
	DepartmentDto fromDepartment(Department department);
	
	Iterable<Department> toDepartments(Iterable<DepartmentDto> departmentDto);
	
	Iterable<DepartmentDto> fromDepartments(Iterable<Department> departments);
}
