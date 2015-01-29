package com.epam.ecsvparser.service;

import org.springframework.batch.core.JobExecution;
import org.springframework.stereotype.Service;

@Service
public class CsvFileProcessor implements FileProcessor {

	@Override
	public JobExecution execute(byte[] multipartFile) {
		// TODO Auto-generated method stub
		// JobExecution execution = jobLauncher.run(job, new JobParameters());
		return null;
	}

}
