package com.epam.ecsvparser.service.dal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.epam.ecsvparser.repository.deparment.Department;
import com.epam.ecsvparser.repository.deparment.DepartmentRepository;
import com.epam.ecsvparser.service.domain.DepartmentDto;
import com.epam.ecsvparser.service.exception.DepartmentNotFoundException;
import com.epam.ecsvparser.service.transformer.department.DepartmentTransformerFacade;

@Component
public class DefaultDepartmentDao implements DepartmentDao {

	private DepartmentRepository departmentRepository;
	private DepartmentTransformerFacade departmentTransformenrFacade;
	
	@Autowired
	public DefaultDepartmentDao(DepartmentRepository departmentRepository,
			DepartmentTransformerFacade departmentTransformenrFacade) {
		this.departmentRepository = departmentRepository;
		this.departmentTransformenrFacade = departmentTransformenrFacade;
	}

	@Override
	public DepartmentDto createDepartment(DepartmentDto departmentDto) {
		Assert.notNull(departmentDto);
		checkDepartmentIfExists(departmentDto);
		
		Department department = departmentRepository.save(departmentTransformenrFacade.toDepartment(departmentDto));
		return departmentTransformenrFacade.fromDepartment(department);
	}

	private void checkDepartmentIfExists(DepartmentDto departmentDto) {
		Department departmentDb = departmentRepository.findOneByName(departmentDto.getName());
		if(departmentDb == null) {
			throw new DepartmentNotFoundException("Department with name:" + departmentDto.getName() + " does not exists.");
		}
	}

	@Override
	public DepartmentDto updateDepartment(DepartmentDto departmentDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteDepartment(String departmentId) {
		departmentRepository.delete(departmentId);
	}

	@Override
	public DepartmentDto getDepartment(String departmentId) {
		return departmentTransformenrFacade.fromDepartment(departmentRepository.findOne(departmentId));
	}

	@Override
	public Iterable<DepartmentDto> getDepartments() {
		Iterable<Department> departments = departmentRepository.findAll();
		return departmentTransformenrFacade.fromDepartments(departments);
	}

	@Override
	public DepartmentDto getDepartmentByName(String departmentName) {
		Department department = departmentRepository.findOneByName(departmentName);
		
		return departmentTransformenrFacade.fromDepartment(department);
	}

}
