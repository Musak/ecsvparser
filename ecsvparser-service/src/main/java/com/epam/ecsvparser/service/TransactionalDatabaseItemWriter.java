package com.epam.ecsvparser.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.epam.ecsvparser.service.domain.EmployeeDto;
import com.epam.ecsvparser.service.exception.FileUploadException;

@Component
@Transactional
public class TransactionalDatabaseItemWriter implements ItemWriter<EmployeeDto> {

	private EmployeeService employeeService;
	
	@Value("#{AppSettings['MaxCSVFileSize']}")
	private Integer MaxCSVFileSize;
	
	@Autowired
	public TransactionalDatabaseItemWriter(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@Override
	public void write(List<? extends EmployeeDto> items) throws Exception {
		if(!items.isEmpty() && items.size() <= MaxCSVFileSize) {
			for (EmployeeDto employeeDto : items) {
				employeeService.createEmployee(employeeDto);
			}
		} else {
			throw new FileUploadException("CSV file size it's too big.");
		}
	}

}
