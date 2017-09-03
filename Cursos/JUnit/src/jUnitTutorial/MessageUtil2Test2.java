package jUnitTutorial;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MessageUtil2Test2 {

   String message = "Robert";	
   MessageUtil2 messageUtil = new MessageUtil2(message);
 
   @Test
   public void testSalutationMessage() {
      System.out.println("Inside testSalutationMessage()");
      message = "Hi!" + "Robert";
      assertEquals(message,messageUtil.salutationMessage());
   }
}