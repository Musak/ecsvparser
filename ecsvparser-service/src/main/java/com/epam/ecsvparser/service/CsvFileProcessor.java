package com.epam.ecsvparser.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.ecsvparser.service.exception.FileUploadException;

@Service
public class CsvFileProcessor implements FileProcessor {

	protected static final Log logger = LogFactory
			.getLog(CsvFileProcessor.class);
	private JobLauncher jobLauncher;
	private Job job;
	private RandomIdentifierGenerator randomIdentifierGenerator;

	@Autowired
	public CsvFileProcessor(JobLauncher jobLauncher, Job job,
			RandomIdentifierGenerator randomIdentifierGenerator) {
		this.jobLauncher = jobLauncher;
		this.job = job;
		this.randomIdentifierGenerator = randomIdentifierGenerator;
	}

	@Override
	public JobExecution process(byte[] bytes) throws FileUploadException {
		File serverFile = uploadfile(bytes);
		String fileName = serverFile.getAbsolutePath();

		JobParameters jobParameters = new JobParametersBuilder().addString(
				"fileName", fileName).toJobParameters();
		JobExecution execution = null;
		try {
			execution = jobLauncher.run(job, jobParameters);
		} catch (JobExecutionAlreadyRunningException | JobRestartException
				| JobInstanceAlreadyCompleteException
				| JobParametersInvalidException | UniqueConstraintException e) {
			throw new FileUploadException("Error Processign CSV file: " + e.getMessage());
		}
		
		if(execution.getStatus().isUnsuccessful()) {
			throw new FileUploadException("Error Saving CSV file");
		}

		return execution;
	}

	private File uploadfile(byte[] bytes) throws FileUploadException {
		File serverFile;
		try {
			String rootPath = System.getProperty("catalina.home");
			File dir = new File(rootPath + File.separator + "tmpFiles");
			if (!dir.exists()) {
				dir.mkdirs();
			}

			serverFile = new File(dir.getAbsolutePath() + File.separator
					+ randomIdentifierGenerator.getRandomIdentifier() + ".csv");
			BufferedOutputStream stream = new BufferedOutputStream(
					new FileOutputStream(serverFile));
			stream.write(bytes);
			stream.close();
		} catch (Exception e) {
			throw new FileUploadException("Unavailable to upload the file: " + e.getMessage());
		}

		return serverFile;
	}

}
