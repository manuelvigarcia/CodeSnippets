package jUnitTutorial;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MessageUtil4Test {

   String message = "Robert";	
   MessageUtil4 messageUtil = new MessageUtil4(message);
   
   @Test(expected = ArithmeticException.class)
   public void testPrintMessage() {	
      System.out.println("Inside testPrintMessage()");     
      messageUtil.printMessage();     
   }

   @Test
   public void testSalutationMessage() {
      System.out.println("Inside testSalutationMessage()");
      message = "Hi!" + "Robert";
      assertEquals(message,messageUtil.salutationMessage());
   }
}