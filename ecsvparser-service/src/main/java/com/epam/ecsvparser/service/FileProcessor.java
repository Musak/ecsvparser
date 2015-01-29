package com.epam.ecsvparser.service;

import java.io.InputStream;

import org.springframework.batch.core.JobExecution;

public interface FileProcessor {
	JobExecution process(byte[] bytes);
}
