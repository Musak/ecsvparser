package com.epam.ecsvparser.repository.deparment;

import static org.testng.Assert.*;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;


public class DepartmentTest {
	private Department department;
	private static final double AVERAGE = 1D;
	private static final String DEPARTMENT_NAME = "DepartmentName";
	private static final String DEPARTMENTID = "departmentid";

	@BeforeMethod
	public void init() {
		department = new Department();
		department.setAverage(AVERAGE);
		department.setDepartmentId(DEPARTMENTID);
		department.setName(DEPARTMENT_NAME);
		department.setEmployees(null);
	}

	@Test
	public void testEqualsShouldReturnTrue() {
		// than 
		assertEquals(department.equals(department), true);
	}
	

	@Test
	public void testEqualsShouldReturnFalse() {
		// than 
		assertEquals(department.equals(new Department()), false);
	}
	
	@Test
	public void testEqualsObjectIsNull() {
		assertNotNull(department);
	}

	@Test
	public void testEqualsObjectIsNotSameClass() {
		// Than
		assertEquals(department.equals(new Object()), false);
	}

}
