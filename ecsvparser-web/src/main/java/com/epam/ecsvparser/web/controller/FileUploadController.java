package com.epam.ecsvparser.web.controller;

import java.io.IOException;

import org.springframework.batch.core.JobExecution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.epam.ecsvparser.service.FileProcessor;

@Controller
public class FileUploadController {

	private FileProcessor fileProcessor;
	
	@Autowired
	public FileUploadController(FileProcessor fileProcessor) {
		this.fileProcessor = fileProcessor;
	}

	@RequestMapping(value="/uploadFile", method=RequestMethod.POST)
	@ResponseBody
	public String uploadFile(@RequestParam("file") MultipartFile file) {
		
		// TODO Call CSVFileProcessor with file and return the result String
		// Autowired the fileprocessor
		
		try {
			JobExecution process = fileProcessor.process(file.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "home";
	}
}
