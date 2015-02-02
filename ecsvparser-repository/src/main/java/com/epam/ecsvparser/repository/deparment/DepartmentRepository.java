package com.epam.ecsvparser.repository.deparment;

import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepository extends CrudRepository<Department, String>  {

	Department findOneByName(String name);

}
