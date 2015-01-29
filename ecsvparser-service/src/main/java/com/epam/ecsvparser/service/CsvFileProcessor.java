package com.epam.ecsvparser.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
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

	private JobLauncher jobLauncher;
	private Job job;
	@Autowired
	public CsvFileProcessor(JobLauncher jobLauncher, Job job) {
		this.jobLauncher = jobLauncher;
		this.job = job;
	}
	@Override
	public JobExecution process(byte[] bytes) {
		// TODO Auto-generated method stub
		// JobExecution execution = jobLauncher.run(job, new JobParameters());
		
		try {
		String rootPath = System.getProperty("catalina.home");                
		File dir = new File(rootPath + File.separator + "tmpFiles");                
		if (!dir.exists())                    
			dir.mkdirs();                 // Create the file on server                
		File serverFile = new File(dir.getAbsolutePath() + File.separator + "valami.csvs");                
		BufferedOutputStream stream = new BufferedOutputStream(                        
				new FileOutputStream(serverFile));                
		stream.write(bytes);                
		stream.close();                 
		System.out.println( "aaaaaaaaaaaaaaaa> "+serverFile.getAbsolutePath());            
		} catch (Exception e) {                
			System.out.println( "aaaaaaaaaaaaaaaa> You failed to upload  => " + e.getMessage());           
		}        
		  
		JobParameters jobParameters = new JobParametersBuilder().addString("fileName", "valami.csv").toJobParameters();
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
		
		return execution;
	}

}
