import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GreeterTest {

    @Test
    void shouldGreetUserInEnglish() {
    Greeter greeter = new Greeter();
    assertEquals(greeter.greet("Vusi",Language.ENGLISH),"Hello Vusi !");

    }
    @Test
    void shouldGreetUserInxiTsonga() {
        Greeter greeter = new Greeter();
        assertEquals(greeter.greet("Vusi",Language.TSONGA),"Avuxeni Vusi !");

    }
    @Test
    void shouldGreetUserInAfrikaans() {
        Greeter greeter = new Greeter();
        assertEquals(greeter.greet("Vusi",Language.AFRIKAANS),"Hallo Vusi !");

    }
}