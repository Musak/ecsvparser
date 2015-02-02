package com.epam.ecsvparser.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.epam.ecsvparser.web.domain.ListDepartmentModel;
import com.epam.ecsvparser.web.facade.ListDepartmantFacade;
import com.epam.ecsvparser.web.urlbuilder.HomeUrlBuilder;

@Controller
public class ListDepartmentController {
	
	private ListDepartmantFacade listDepartmentFacade; 

	@Autowired
	public ListDepartmentController(ListDepartmantFacade listDepartmentFacade) {
		this.listDepartmentFacade = listDepartmentFacade;
	}
	
	@ModelAttribute("listDepartmentModel")
	public ListDepartmentModel listDepartmentModel() {
		return listDepartmentFacade.createListDepartmentModel();
	}
	
	@RequestMapping(value= HomeUrlBuilder.LIST_URL, method = RequestMethod.GET)
	public String listPage() {
		return "list";
	}
}
