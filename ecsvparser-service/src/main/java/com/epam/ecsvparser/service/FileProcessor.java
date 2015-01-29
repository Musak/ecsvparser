package com.epam.ecsvparser.service;

import org.springframework.batch.core.JobExecution;

public interface FileProcessor {
	JobExecution execute(byte[] multipartFile);
}
