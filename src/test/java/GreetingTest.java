import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GreetingTest {

    @Test
    void greet() {
        Greeting greeting = new Greeting();
        greeting.commandInit("greet Amu English");
        greeting.commandInit("greet Joe Tsonga");
        assertEquals(greeting.greet("Joe"),"Avuxeni Joe!");
        assertEquals(greeting.counter(),2);


    }

    @Test
    void counter() {
    }
}