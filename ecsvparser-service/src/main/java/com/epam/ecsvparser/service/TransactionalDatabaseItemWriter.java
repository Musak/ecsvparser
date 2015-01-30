package com.epam.ecsvparser.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.epam.ecsvparser.service.domain.EmployeeDto;

@Component
public class TransactionalDatabaseItemWriter implements ItemWriter<EmployeeDto> {

	private EmployeeService employeeService;

	@Autowired
	public TransactionalDatabaseItemWriter(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@Override
	public void write(List<? extends EmployeeDto> items) throws Exception {
		if(!items.isEmpty()) {
			for (EmployeeDto employeeDto : items) {
				employeeService.createEmployee(employeeDto);
			}
		}
	}

}
