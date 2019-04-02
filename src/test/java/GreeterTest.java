package net.greet;

import greet.Greeter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GreeterTest {

    @Test
    void shouldGreetUserInEnglish() {
    Greeter greeter = new Greeter();
    assertEquals(greeter.greet("Vusi","English"),"Hello Vusi!");

    }
    @Test
    void shouldGreetUserInxiTsonga() {
        Greeter greeter = new Greeter();
        assertEquals(greeter.greet("Vusi","Tsonga"),"Avuxeni Vusi!");

    }
    @Test
    void shouldGreetUserInAfrikaans() {
        Greeter greeter = new Greeter();
        assertEquals(greeter.greet("Vusi","Afrikaans"),"Hallo Vusi!");

    }
}