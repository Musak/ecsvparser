package com.epam.ecsvparser.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashSet;
import java.util.Random;

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

@Service
public class CsvFileProcessor implements FileProcessor {

	protected static final Log logger = LogFactory.getLog(CsvFileProcessor.class);
	private JobLauncher jobLauncher;
	private Job job;
	private RandomIdentifierGenerator randomIdentifierGenerator;
	
	@Autowired
	public CsvFileProcessor(JobLauncher jobLauncher, Job job, RandomIdentifierGenerator randomIdentifierGenerator) {
		this.jobLauncher = jobLauncher;
		this.job = job;
		this.randomIdentifierGenerator = randomIdentifierGenerator;
	}
	
	@Override
	public JobExecution process(byte[] bytes) {
		// TODO Upload it is a different process, should refactor 
		String fileName = uploadfile(bytes);        
		  
		JobParameters jobParameters = new JobParametersBuilder().addString("fileName", fileName).toJobParameters();
		JobExecution execution = null;
		try {
			execution = jobLauncher.run(job, jobParameters);
		} catch (JobExecutionAlreadyRunningException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JobRestartException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JobInstanceAlreadyCompleteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JobParametersInvalidException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String status = execution.getStatus().name();
		logger.info("Your process status: " + status);
		
		return execution;
	}
	
	private String uploadfile(byte[] bytes) {
		String fileName = "";
		try {
		String rootPath = System.getProperty("catalina.home");                
		File dir = new File(rootPath + File.separator + "tmpFiles");                
		if (!dir.exists()) {                   
			dir.mkdirs();                 // Create the file on server                
		}
		
		File serverFile = new File(dir.getAbsolutePath() + File.separator + randomIdentifierGenerator.getRandomIdentifier() + ".csv");                
		BufferedOutputStream stream = new BufferedOutputStream(                        
				new FileOutputStream(serverFile));                
		stream.write(bytes);                
		stream.close();
		
		fileName = serverFile.getAbsolutePath();
		logger.info("Uploaded file path: " + fileName);          
		} catch (Exception e) {
			logger.debug("You failed to upload  => " + fileName + " " + e.getMessage());      
		}
		return fileName;
	}

}
