package com.epam.ecsvparser.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.ecsvparser.service.dal.DepartmentDao;
import com.epam.ecsvparser.service.domain.DepartmentDto;

@Service
public class DefaultDepartmentService implements DepartmentService {

	private DepartmentDao departmentDao;

	@Autowired
	public DefaultDepartmentService(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}

	@Override
	public List<DepartmentDto> getDepartments() {
		Iterable<DepartmentDto> departments = departmentDao.getDepartments();
		return (List<DepartmentDto>) departments;
	}

	@Override
	public DepartmentDto getDepartmentByName(String readString) {
		return departmentDao.getDepartmentByName(readString);
	}

	@Override
	public Double getSalaryAverage(DepartmentDto department) {
		return departmentDao.getSalaryAverage(department);
	}
}
