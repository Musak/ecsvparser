package com.epam.ecsvparser.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.epam.ecsvparser.web.urlbuilder.ErrorhandlingUrlBuilder;

@Controller
@RequestMapping(ErrorhandlingUrlBuilder.PAGE_NOT_FOUND_URL)
public class PageNotFoundController {

	@RequestMapping
	public String pageNotFound() {
		return "not_found";
	}
}
