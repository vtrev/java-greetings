import command.CommandProcessor;
import counter.Counter;

import java.sql.SQLException;

class InputProcessor {
     private Greeter greeter;
     private Counter counter;
     private CommandProcessor cp;

     InputProcessor(Greeter greeter, Counter counter, CommandProcessor commandProcessor) {
         this.greeter = greeter;
         this.counter = counter;
         this.cp = commandProcessor;
     }

     boolean processInput(String userInput)throws SQLException {
         cp.processCommand(userInput);
         switch (cp.getCommand()) {
             case ("greet"):
                 if (cp.getName() == null) {
                     return displayResult("Please add your name after the greet command.", true);
                 }
                 displayResult(greeter.greet(cp.getName(),cp.getLangauge()), true);
                 counter.addUser(cp.getName());
                 break;
             case ("greeted"):
                 if (cp.getName() != null) {
                     return displayResult("User " + cp.getName() + " has been greeted " + counter.getCount(cp.getName()) + " times.", true);
                 }
                 displayResult("Total number of users greeted : " + counter.getCount(), true);
                 break;
             case ("clear"):
                 if (cp.getName() != null) {
                     return displayResult(counter.clear(cp.getName()), true);
                 }
                 displayResult(counter.clear(), true);
                 break;
             case ("help"):
                 System.out.println("Help");
                 break;
             case ("exit"):
                 return displayResult(" Thanks for using the app.Goodbye!", false);
             default:
                 displayResult("Error! Invalid command, please try again or type help for a valid  command list.", true);
                 break;
         }
         return true;
     }
     private boolean displayResult(String result,boolean menu){
         System.out.println(result +"\n");
         return menu;
     }
 }