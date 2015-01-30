package com.epam.ecsvparser.repository;

import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, String> {
	Employee findByFirstNameAndLastName(String firstName, String lastName);

}
