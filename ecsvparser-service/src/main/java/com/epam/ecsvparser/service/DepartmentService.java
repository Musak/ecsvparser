package com.epam.ecsvparser.service;

import java.util.List;

import com.epam.ecsvparser.service.domain.DepartmentDto;
import com.epam.ecsvparser.service.domain.EmployeeDto;

public interface DepartmentService {
	List<DepartmentDto> getDepartments();

	DepartmentDto getDepartmentByName(String readString);
	
	Double getSalaryAverage(DepartmentDto department);

	DepartmentDto updateDepartment(DepartmentDto departmentDto);
}
