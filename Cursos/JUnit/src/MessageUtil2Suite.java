package jUnitTutorial;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
   MessageUtil2Test.class,
   MessageUtil2Test2.class
})
public class MessageUtil2Suite {   
}  	