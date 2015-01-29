package com.epam.ecsvparser.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.epam.ecsvparser.web.urlbuilder.HomeUrlBuilder;

@Controller
public class HomeController {

	@RequestMapping(HomeUrlBuilder.HOME_URL)
	public String home() {
		return "home";
	}
}
