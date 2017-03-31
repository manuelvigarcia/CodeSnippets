package jUnitTutorial;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class EmployeeDetailsTest {
	EmployeeDetails employee = new EmployeeDetails();
	
	@Before
	public void setUp(){
		employee.setAge(25);
		employee.setName("Arturo Pérez Reverte Otravez");
		employee.setMonthlySalary(2000);
	}

	@After
	public void takeDown(){
		employee = null;
	}

	@Test
	public void testGetAge(){
		assertEquals(25, employee.getAge());
	}
	@Test
	public void testGetMonthlySalary(){
		assertTrue(2000 == employee.getMonthlySalary());
	}
	@Test
	public void testGetName(){
		assertEquals("Arturo Pérez Reverte Otravez", employee.getName());
	}
	@Test
	public void testSetAge(){
		employee.setAge(30);
		assertEquals(30, employee.getAge());
	}
	@Test
	public void testSetMonthlySalary(){
		employee.setMonthlySalary(3000);
		assertTrue(3000 == employee.getMonthlySalary());
	}
	@Test
	public void testSetName(){
		employee.setName("Corropopito");
		assertEquals("Corropopito", employee.getName());
	}

}
