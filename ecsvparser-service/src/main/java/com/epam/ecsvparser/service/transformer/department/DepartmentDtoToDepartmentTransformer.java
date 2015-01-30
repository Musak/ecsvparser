package com.epam.ecsvparser.service.transformer.department;

import com.epam.ecsvparser.repository.Department;
import com.epam.ecsvparser.service.domain.DepartmentDto;

public interface DepartmentDtoToDepartmentTransformer {
	Department transform(DepartmentDto departmentDto);
}
