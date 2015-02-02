package com.epam.ecsvparser.web.transformer;

import java.util.List;

import com.epam.ecsvparser.service.domain.DepartmentDto;
import com.epam.ecsvparser.web.domain.DepartmentView;

public interface DepartmentViewTransformer {
	
	DepartmentView transform(DepartmentDto department);
	List<DepartmentView> transform(List<DepartmentDto> departments);
}
