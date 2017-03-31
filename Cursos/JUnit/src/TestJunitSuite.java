package jUnitTutorial;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

//JUnit Suite Test
@RunWith(Suite.class)
@Suite.SuiteClasses({ 
   TestJUnit1.class ,TestJUnit2.class
})
public class TestJunitSuite {
}