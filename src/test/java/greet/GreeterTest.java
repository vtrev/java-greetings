package greet;

import greet.command.Command;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GreeterTest {

    @Test
    void shouldGreetUserInEnglish() {
    Greeter greeter = new Greeter();
        Command command = new Command("greet Vusi English");
    assertEquals(greeter.greet(command),"Hello Vusi!");

    }
    @Test
    void shouldGreetUserInxiTsonga() {
        Greeter greeter = new Greeter();
        Command command = new Command("greet Vusi Tsonga");
        assertEquals(greeter.greet(command),"Avuxeni Vusi!");

    }
    @Test
    void shouldGreetUserInAfrikaans() {
        Greeter greeter = new Greeter();
        Command command = new Command("greet Vusi Afrikaans");
        assertEquals(greeter.greet(command),"Hallo Vusi!");
    }

    @Test
    void shouldGreetUserInEnglishAsDefaultLanguage(){
        Greeter greeter = new Greeter();
        Command command = new Command("greet Vusi");
        assertEquals(greeter.greet(command),"Hello Vusi!");
    }
}