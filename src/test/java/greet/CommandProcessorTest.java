package greet;
import greet.command.Command;
import greet.command.Process.*;
import greet.command.ProcessCommand;
import greet.counter.Counter;
import greet.counter.DatabaseCounter;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CommandProcessorTest {
    @Test
    void shouldProcessGreetCommand(){
            // Assembly
            DatabaseCounter databaseCounterMock = Mockito.mock(DatabaseCounter.class);
            Greeter greeterMock = Mockito.mock(Greeter.class);
                // add behavior

        Command command = new Command("greet Vusi English");
            when(greeterMock.greet(command)).thenReturn("Hello Vusi!");
            Map<String, ProcessCommand> commandMap = new HashMap<>();
            commandMap.put("greet", new GreetProcessor(databaseCounterMock, greeterMock));
            CommandProcessor commandProcessor = new CommandProcessor(commandMap);
            // Action
            Result res = commandProcessor.process("greet Vusi English");
            // Assertions and verifications
            assertEquals(res.getResult(),"Hello Vusi!");
            // has countUser been called with the right params
            verify(databaseCounterMock,times(1)).countUser("Vusi");
        }


    @Test
    void shouldProcessGreetedCommand(){
        // Assembly
        Counter counterMock = Mockito.mock(Counter.class);
            //add behavior
            when(counterMock.userGreetCount("Vusi")).thenReturn(5);
            when(counterMock.totalGreetCount()).thenReturn(56);


        Map<String, ProcessCommand> commandMap = new HashMap<>();
        commandMap.put("greeted", new CountProcessor(counterMock));
        CommandProcessor commandProcessor = new CommandProcessor(commandMap);
        // Action
        Result res = commandProcessor.process("greeted Vusi");
        Result res1 = commandProcessor.process("greeted");
        // Assertion
        assertEquals(res.getResult(),"User Vusi has been greeted 5 times.");
        assertEquals(res1.getResult(),"Total number of users greeted : 56");
        // has countUser been called with the right params
            verify(counterMock,times(1)).userGreetCount("Vusi");
            verify(counterMock,times(1)).totalGreetCount();
    }

    @Test
    void shouldProcessClearCommand(){
        //assembly
        Counter counterMock = Mockito.mock(Counter.class);
        //add behavior
            when(counterMock.clearAllUserCounts()).thenReturn(true);
            when(counterMock.clearUserCount("Vusi")).thenReturn(true);
            when(counterMock.countUser("UnknownUser")).thenReturn(false);

        Map<String, ProcessCommand> commandMap = new HashMap<>();
        commandMap.put("clear", new ClearProcessor(counterMock));
        CommandProcessor commandProcessor = new CommandProcessor(commandMap);
        //action
        Result res = commandProcessor.process("clear");
        Result res1 = commandProcessor.process("clear Vusi");
        Result res2 = commandProcessor.process("clear UnknownUser");
        //assertions
        assertEquals(res.getResult(),"All users cleared successfully");
        assertEquals(res1.getResult(),"User: Vusi cleared successfully");
        assertEquals(res2.getResult(),"Error while clearing, user UnknownUser does not exist");

    }

    @Test
    void shouldProcessHelpCommand(){
        Map<String, ProcessCommand> commandMap = new HashMap<>();
        commandMap.put("help", new HelpProcessor());
        CommandProcessor commandProcessor = new CommandProcessor(commandMap);
        Result res = commandProcessor.process("help");
        String helpText = "Greetings Console App Help Page \n General Commands : [greet,greeted,clear,help,exit]. \n Synopses \n" +
                "1. greet [username] [option] - Returns a greet on the screen. \n " +
                "\t Username(required) : The name of user to greet. \n " +
                "\t Option : A language in which the user will be greeted in .\n" +
                "2. greeted [option] - Returns the number of times a user has been greeted. \n " +
                "\t Option : The name of the user to get count for. \n"  +
                "3. clear [option] - Removes the count from database. \n" +
                " \t Option : The name of the user to clear,clears every user if no option is given .\n"  +
                "4. help - Prints out current screen. \n" +
                "5. exit - Exits the app. \n";

        assertEquals(res.getResult(),helpText);
    }
    @Test
    void shouldProcessExitCommand(){
        Map<String, ProcessCommand> commandMap = new HashMap<>();
        commandMap.put("exit", new ExitProcessor());
        CommandProcessor commandProcessor = new CommandProcessor(commandMap);
        Result res = commandProcessor.process("exit");

        assertEquals(res.getResult(),"Thanks for using the app,goodbye!");

    }
}
