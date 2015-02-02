package com.epam.ecsvparser.web.domain;

import java.util.List;

public class ListDepartmentModel {
	private String newCsvUploadLink;
	private List<DepartmentView> departments;
	
	public String getNewCsvUploadLink() {
		return newCsvUploadLink;
	}
	public void setNewCsvUploadLink(String newCsvUploadLink) {
		this.newCsvUploadLink = newCsvUploadLink;
	}
	public List<DepartmentView> getDepartments() {
		return departments;
	}
	public void setDepartments(List<DepartmentView> departments) {
		this.departments = departments;
	}
}
