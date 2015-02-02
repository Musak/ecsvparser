package com.epam.ecsvparser.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.epam.ecsvparser.service.FileProcessor;
import com.epam.ecsvparser.web.urlbuilder.HomeUrlBuilder;

@Controller
public class FileUploadController {

	private FileProcessor fileProcessor;
	
	@Autowired
	public FileUploadController(FileProcessor fileProcessor) {
		this.fileProcessor = fileProcessor;
	}

	@RequestMapping(value="/uploadFile", method=RequestMethod.POST)
	public String uploadFile(@RequestParam("file") MultipartFile file,
			final RedirectAttributes redirectAttributes) {
		
		try {
			fileProcessor.process(file.getBytes());
			redirectAttributes.addFlashAttribute("message","CSV File Successfully uploaded and stored in database.");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
		}
		
		return "redirect:"+HomeUrlBuilder.HOME_URL;
	}
	
	@RequestMapping(value="/uploadFile", method=RequestMethod.GET)
	public String uploadFileHome() {
		return "home";
	}
}
