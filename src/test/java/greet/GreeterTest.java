package greet;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GreeterTest {

    @Test
    void shouldGreetUserInDefaultLanguage() {
        Greeter greeter = new Greeter();
        assertEquals(greeter.greet("Vusi"),"Hello Vusi !");
    }
    @Test
    void shouldGreetUserInGivenLangauge(){
        Greeter greeter = new Greeter();
        assertEquals(greeter.greet("Bheki",Language.TSONGA),"Avuxeni Bheki !");
    }
    @Test
    void shouldReturnCorrectTotalCount(){
        Greeter greeter = new Greeter();
        greeter.greet("Vusi");
        greeter.greet("Rangi");
        greeter.greet("Anko",Language.AFRIKAANS);
        assertEquals(greeter.getCount(),3);
    }
    @Test
    void shouldReturTotalCorrectCountForUser(){
        Greeter greeter = new Greeter();
        greeter.greet("Vusi");
        greeter.greet("Vusi",Language.TSONGA);
        greeter.greet("Vusi",Language.ENGLISH);
        greeter.greet("Anko",Language.AFRIKAANS);
        assertEquals(greeter.getCount("Vusi"),3);
        assertEquals(greeter.getCount("Anko"),1);
    }
    @Test
    void shouldClearAllUserCounts(){
        Greeter greeter = new Greeter();
        greeter.greet("Vusi");
        greeter.greet("Yoda");
        greeter.greet("Bheki",Language.TSONGA);
        greeter.clear();
        assertEquals(greeter.getCount(),0);
    }

    @Test
    void shouldClearSpecificUserCount(){
        Greeter greeter = new Greeter();
        greeter.greet("Joe",Language.AFRIKAANS);
        greeter.greet("Yoda");
        greeter.greet("Abel",Language.TSONGA);
        //user exists before being cleared and total count is 3
        assertEquals(greeter.userExists("Abel"),true);
        assertEquals(greeter.getCount(),3);

        greeter.clear("Abel");

        //user nolonger exists and total count is down by 1
        assertEquals(greeter.userExists("Abel"),false);
        assertEquals(greeter.getCount(),2);

    }

}