package com.epam.ecsvparser.repository.employee;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import com.epam.ecsvparser.repository.deparment.Department;

public class EmployeeTest {
	private static final String EMPLOYEE_ID = "EMPLOYEE ID";

	private static final String FIRSTNAME = "FIRSTNAME";

	private static final String LASTNAME = "LASTNAME";

	private static final int SALARY = 100000;

	private Employee employee;
	private Department department;
	
	private static final double AVERAGE = 1D;
	private static final String DEPARTMENT_NAME = "DepartmentName";
	private static final String DEPARTMENTID = "departmentid";

	@BeforeMethod
	public void init() {
		employee = new Employee();
		
		department = new Department();
		department.setAverage(AVERAGE);
		department.setDepartmentId(DEPARTMENTID);
		department.setName(DEPARTMENT_NAME);
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(employee);
		
		employee.setDepartment(department);
		employee.setEmployeeId(EMPLOYEE_ID);
		employee.setFirstName(FIRSTNAME);
		employee.setLastName(LASTNAME);
		employee.setSalary(SALARY);
	}

	@Test
	public void testEqualsShouldReturnTrue() {
		Assert.assertEquals(employee.equals(employee), true)
		;
	}

	@Test
	public void testEqualsShouldReturnFalse() {
		// than 
		assertEquals(employee.equals(new Employee()), false);
	}
	
	@Test
	public void testEqualsObjectIsNull() {
		assertNotNull(employee);
	}

	@Test
	public void testEqualsObjectIsNotSameClass() {
		// Than
		assertEquals(employee.equals(new Object()), false);
		assertEquals(employee.equals(null), false);	
	}
	@Test 
	public void testFields() {
		assertNotNull(employee);
		assertEquals(employee.getDepartment(), department);
		assertEquals(employee.getFirstName(), FIRSTNAME);
		assertEquals(employee.getLastName(), LASTNAME);
		assertEquals(employee.getEmployeeId(), EMPLOYEE_ID);
	} 

}
