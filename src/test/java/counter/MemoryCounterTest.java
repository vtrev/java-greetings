package counter;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MemoryCounterTest {

    @Test
    void shouldReturnCorrectTotalCount() {
        MemoryCounter counter = new MemoryCounter();
        //count before adding user
        assertEquals(counter.totalGreetCount(),0);
        counter.countUser("Vusi");
        counter.countUser("Jimmy");
        counter.countUser("Baloyi");
        //count after user is added
        assertEquals(counter.totalGreetCount(),3);
    }

    @Test
    void shouldReturnCorrectUserCount () {
        MemoryCounter counter = new MemoryCounter();
        int i = 5;
        while(i>0){
            counter.countUser("Vusi");
            if(i>3){
                counter.countUser("Rangi");
            }
            i--;
        }
        assertEquals(counter.userGreetCount("Rangi"),2);
        assertEquals(counter.userGreetCount("Vusi"),5);
    }

    @Test
    void shouldClearAllUsers() {
        MemoryCounter counter = new MemoryCounter();
        counter.countUser("Vusi");
        counter.countUser("Urangani");
        counter.clearAllUserCounts();
        assertEquals(counter.totalGreetCount(),0);
    }

    @Test
    void shouldClearUserCount() {
        MemoryCounter counter = new MemoryCounter();
        counter.countUser("Vusi");
        counter.clearUserCount("Vusi");
        assertEquals(counter.userGreetCount("Vusi"),0);
    }
}