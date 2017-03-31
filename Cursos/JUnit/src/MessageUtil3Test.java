package jUnitTutorial;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MessageUtil3Test {

   String message = "Robert";	
   MessageUtil3 messageUtil = new MessageUtil3(message);
   

   @Test(timeout=1000)
   public void testPrintMessage() {
      System.out.println("Inside testPrintMessage()");
      message = "Robert";
      assertEquals(message,messageUtil.printMessage());
   }

   @Test
   public void testSalutationMessage() {
      System.out.println("Inside testSalutationMessage()");
      message = "Hi!" + "Robert";
      assertEquals(message,messageUtil.salutationMessage());
   }
}