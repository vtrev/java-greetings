import command.CommandProcessor;
import counter.Counter;

import java.sql.SQLException;

class InputProcessor {
     private Greeter greeter;
     private Counter counter;
     private CommandProcessor cp;
     private  Action action;

     InputProcessor(Greeter greeter, Counter counter, CommandProcessor commandProcessor) {
         this.greeter = greeter;
         this.counter = counter;
         this.cp = commandProcessor;
         this.action = new Action(this.cp,this.counter,this.greeter);
     }

     boolean processInput(String userInput)throws SQLException {
         cp.processCommand(userInput);
         switch (cp.getCommand()) {
             case ("greet"):
                 return displayResult(action.greet(),true);
             case ("greeted"):
                 return displayResult(action.count(),true);

             case ("clear"):
                 if(action.clear()){
                     displayResult("Clear successful",true);
                 }
                 return displayResult("Error while clearing",true) ;

             case ("help"):
                 System.out.println("Help");
                 break;
             case ("exit"):
                  return  displayResult(" Thanks for using the app.Goodbye!", false);
         }
         return displayResult("Error! Invalid command, please try again or type help for a valid  command list.", true);
     }
     private boolean displayResult(String result,boolean menu){
         System.out.println(result +"\n");
         return menu;
     }
 }