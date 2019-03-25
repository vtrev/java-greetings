package counter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MemoryMemoryCounterTest {

    @Test
    void shouldReturnCorrectTotalCount() {
        MemoryCounter counter = new MemoryCounter();
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
        MemoryCounter counter = new MemoryCounter();
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
    MemoryCounter counter = new MemoryCounter();
    counter.addUser("Vusi");
    counter.addUser("Urangani");
    counter.clear();
    assertEquals(counter.getCount(),0);
    }

    @Test
    void shouldClearUserCount() {
        MemoryCounter counter = new MemoryCounter();
        counter.addUser("Vusi");
        counter.clear("Vusi");
        assertEquals(counter.getCount("Vusi"),0);
    }
}