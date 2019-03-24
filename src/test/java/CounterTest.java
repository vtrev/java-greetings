import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CounterTest {

    @Test
    void shouldReturnCorrectTotalCount() {
        Counter counter = new Counter();
        //count before adding user
        assertEquals(counter.getCount(),0);
        counter.addUser("Vusi");
        counter.addUser("Jimmy");
        counter.addUser("Baloyi");
        //count after user is added
        assertEquals(counter.getCount(),3);
    }

    @Test
    void shouldReturnCorrectUserCount () {
        Counter counter = new Counter();
        int i = 5;
        while(i>0){
            counter.addUser("Vusi");
            if(i>3){
                counter.addUser("Rangi");
            }
            i--;
        }
        assertEquals(counter.getCount("Rangi"),2);
        assertEquals(counter.getCount("Vusi"),5);
    }

    @Test
    void shouldClearAllUsers() {
    Counter counter = new Counter();
    counter.addUser("Vusi");
    counter.addUser("Urangani");
    counter.clear();
    assertEquals(counter.getCount(),0);
    }

    @Test
    void shouldClearUserCount() {
        Counter counter = new Counter();
        counter.addUser("Vusi");
        counter.clear("Vusi");
        assertEquals(counter.getCount("Vusi"),0);
    }
}