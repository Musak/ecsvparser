package com.epam.ecsvparser.service.transformer.department;

import com.epam.ecsvparser.repository.deparment.Department;
import com.epam.ecsvparser.service.domain.DepartmentDto;

public interface DepartmentToDepartmentDtoTransformer {
	DepartmentDto transform(Department department);
}
