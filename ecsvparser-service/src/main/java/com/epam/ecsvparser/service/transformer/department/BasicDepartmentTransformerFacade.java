package com.epam.ecsvparser.service.transformer.department;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.epam.ecsvparser.repository.Department;
import com.epam.ecsvparser.service.domain.DepartmentDto;

@Component
public class BasicDepartmentTransformerFacade implements
		DepartmentTransformerFacade {

	private DepartmentToDepartmentDtoTransformer departmentToDepartmentDtoTransformer;
	private DepartmentDtoToDepartmentTransformer departmentDtoToDepartmentTransformer;
	
	@Autowired
	public BasicDepartmentTransformerFacade(
			DepartmentToDepartmentDtoTransformer departmentToDepartmentDtoTransformer,
			DepartmentDtoToDepartmentTransformer departmentDtoToDepartmentTransformer) {
		this.departmentToDepartmentDtoTransformer = departmentToDepartmentDtoTransformer;
		this.departmentDtoToDepartmentTransformer = departmentDtoToDepartmentTransformer;
	}

	@Override
	public Department toDepartment(DepartmentDto departmentDto) {
		return departmentDtoToDepartmentTransformer.transform(departmentDto);
	}

	@Override
	public DepartmentDto fromDepartment(Department department) {
		return departmentToDepartmentDtoTransformer.transform(department);
	}

	@Override
	public Iterable<Department> toDepartments(
			Iterable<DepartmentDto> departmentDto) {
		Iterator<DepartmentDto> iterator = departmentDto.iterator();
		List<Department> departments = new ArrayList<Department>();
		while (iterator.hasNext()) {
			departments.add(this.toDepartment(iterator.next()));
		}
		return departments;
	}

	@Override
	public Iterable<DepartmentDto> fromDepartments(
			Iterable<Department> departments) {
		Iterator<Department> iterator = departments.iterator();
		List<DepartmentDto> departmentDtos = new ArrayList<DepartmentDto>();
		while (iterator.hasNext()) {
			departmentDtos.add(this.fromDepartment(iterator.next()));
		}
		return departmentDtos;
	}

}
