package jUnitTutorial;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	EmpBusinessLogicTest.class,
	EmployeeDetailsTest.class
})

public class JUnitTutorialSuite {
}
