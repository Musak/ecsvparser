package com.epam.ecsvparser.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository  extends CrudRepository<Employee, String> {
	Employee findByFirstNameAndLastName(String firstName, String lastName);

}