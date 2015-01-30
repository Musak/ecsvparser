package com.epam.ecsvparser.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.epam.ecsvparser.web.urlbuilder.ErrorhandlingUrlBuilder;

@Controller
@RequestMapping(ErrorhandlingUrlBuilder.ERROR_PAGE_URL)
public class ErrorController {

	@RequestMapping
	public String customError() {
		return "error_generic";
	}
}
