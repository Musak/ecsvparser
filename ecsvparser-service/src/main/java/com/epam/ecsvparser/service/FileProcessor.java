package com.epam.ecsvparser.service;

import org.springframework.batch.core.JobExecution;

import com.epam.ecsvparser.service.exception.FileUploadException;

public interface FileProcessor {
	JobExecution process(byte[] bytes) throws FileUploadException;
}
