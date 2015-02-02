package com.epam.ecsvparser.service.dal;

import com.epam.ecsvparser.service.domain.DepartmentDto;

public interface DepartmentDao {
		DepartmentDto createDepartment(DepartmentDto departmentDto);
		
		DepartmentDto updateDepartment(DepartmentDto departmentDto);
		
		void deleteDepartment(String departmentId);
		
		DepartmentDto getDepartment(String departmentId);
		
		Iterable<DepartmentDto> getDepartments();

		DepartmentDto getDepartmentByName(String readString);
		
		Double getSalaryAverage(DepartmentDto departmentId);
}
