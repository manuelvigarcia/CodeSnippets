package jUnitTutorial;

/*
* This class prints the given message on console.
*/
public class MessageUtil3 {

   private String message;

   //Constructor
   //@param message to be printed
   public MessageUtil3(String message){
      this.message = message; 
   }

   // prints the message
   public String printMessage(){
      System.out.println(message);
      while(true);
      //return message;
   }   

   // add "Hi!" to the message
   public String salutationMessage(){
      message = "Hi!" + message;
      System.out.println(message);
      return message;
   }   
}  