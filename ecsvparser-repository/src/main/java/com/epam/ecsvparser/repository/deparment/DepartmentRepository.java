package com.epam.ecsvparser.repository.deparment;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface DepartmentRepository extends CrudRepository<Department, String>  {

	Department findOneByName(String name);
	
	@Query("SELECT avg(e.salary) FROM Employee e WHERE e.department = :id GROUP BY e.department")
	Double getSalaryAverage(@Param("id") Department department);
}
