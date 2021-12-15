package greet.command;

import greet.Language;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CommandTest {
    //given a user input string in these command objects, they should be able to do what the test methods say

    @Test
    void shouldGetCommand() {
        Command command = new Command("greet Vusi");
        Command command1 = new Command("greeted Joe");
        Command command2 = new Command("clear");
        Command command3 = new Command("help");
        Command command4 = new Command("exit");

        assertEquals(command.getCommand(), "greet");
        assertEquals(command1.getCommand(),"greeted");
        assertEquals(command2.getCommand(),"clear");
        assertEquals(command3.getCommand(),"help");
        assertEquals(command4.getCommand(),"exit");
    }

    @Test
    void shouldTellIfCommandIsInvalid(){
        Command command = new Command("Some invalid command here");
        assertEquals(command.getCommand(),"Invalid command");
    }

    @Test
    void shouldGetName() {
        Command command = new Command("greet Vusi English");
        Command command2 = new Command("clear Mike");
        Command command3 = new Command("greeted Andrew");

        assertEquals(command.getName(),"Vusi");
        assertEquals(command2.getName(),"Mike");
        assertEquals(command3.getName(),"Andrew");
    }

    @Test
    void shouldAlwaysReturnNameInCamelCase(){
        Command command = new Command("greet vusi English");
        Command command2 = new Command("greet bheki");
        assertEquals(command.getName(),"Vusi");
        assertEquals(command2.getName(),"Bheki");
    }

    @Test
    void shouldGetTheLanguage(){
        Command command = new Command("greet Vusi English");
        Command command2 = new Command("greet Bhekmuzi Tsonga");
        assertEquals(command.getLanguage(), Language.ENGLISH);
        assertEquals(command2.getLanguage(),Language.TSONGA);
    }
}