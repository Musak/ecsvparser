package com.epam.ecsvparser.web.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.epam.ecsvparser.service.DepartmentService;
import com.epam.ecsvparser.web.domain.ListDepartmentModel;
import com.epam.ecsvparser.web.transformer.DepartmentViewTransformer;
import com.epam.ecsvparser.web.urlbuilder.HomeUrlBuilder;

@Component
public class DefaultListDepartmentFacade implements ListDepartmantFacade {

	private DepartmentService departmentService;
	private DepartmentViewTransformer departmentViewTransformer;

	@Autowired
	public DefaultListDepartmentFacade(DepartmentService departmentService,
			DepartmentViewTransformer departmentViewTransformer) {
		this.departmentService = departmentService;
		this.departmentViewTransformer = departmentViewTransformer;
	}

	@Override
	public ListDepartmentModel createListDepartmentModel() {
		ListDepartmentModel listDepartmentModel = new ListDepartmentModel();
		listDepartmentModel.setNewCsvUploadLink(HomeUrlBuilder.HOME_URL);
		listDepartmentModel.setDepartments(departmentViewTransformer.transform(departmentService.getDepartments()));
		return listDepartmentModel;
	}

}
