package com.epam.ecsvparser.web.transformer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.epam.ecsvparser.service.domain.DepartmentDto;
import com.epam.ecsvparser.web.domain.DepartmentView;

@Component
public class DefaultDepartmentViewTransformer implements DepartmentViewTransformer {

	@Override
	public DepartmentView transform(DepartmentDto department) {
		DepartmentView departmentView = new DepartmentView();
		departmentView.setAvarage(department.getAverage());
		departmentView.setDepartmentName(department.getName());
		
		return departmentView;
	}

	@Override
	public List<DepartmentView> transform(List<DepartmentDto> departments) {
		List<DepartmentView> departmentsView = new ArrayList<DepartmentView>();
		for (DepartmentDto department : departments) {
			departmentsView.add(this.transform(department));
		}
		
		return departmentsView;
	}
	
}
