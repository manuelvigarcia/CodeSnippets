package jUnitTutorial;

/*
* This class prints the given message on console.
*/
public class MessageUtil4 {

   private String message;

   //Constructor
   //@param message to be printed
   public MessageUtil4(String message){
      this.message = message; 
   }

   // prints the message
   public void printMessage(){
      System.out.println(message);
      int a =0;
      int b = 1/a;
      if (b > 0) System.out.println("Passed Exception point");
   }   

   // add "Hi!" to the message
   public String salutationMessage(){
      message = "Hi!" + message;
      System.out.println(message);
      return message;
   }   
}  	