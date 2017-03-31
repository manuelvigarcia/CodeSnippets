package jUnitTutorial;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MessageUtil2Test {

   String message = "Robert";	
   MessageUtil messageUtil = new MessageUtil(message);
   
   @Test
   public void testPrintMessage() {	
      System.out.println("Inside testPrintMessage()");    
      assertEquals(message, messageUtil.printMessage());     
   }
}