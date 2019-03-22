import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProcessorTest {

    @Test
    void shouldReturnCommandGivenString() {
        Processor processor = new Processor("greet Vusi English");
        Processor processor1 = new Processor("greeted Vusi");
        Processor processor2 = new Processor("clear Vusi");
        assertEquals(processor.getCommand(),"greet");
        assertEquals(processor1.getCommand(),"greeted");
        assertEquals(processor2.getCommand(),"clear");
    }

    @Test
    void shouldReturnNameFromCommandString() {
        Processor processor = new Processor("greet Joey English");
        assertEquals(processor.getName(),"Joey");
    }

    @Test
    void shouldReturnOptionFromCommandString() {
        Processor processor = new Processor("greet Joey Afrikaans");
        Processor processor1 = new Processor("greeted Joey");
        Processor processor2 = new Processor("clear");

        assertEquals(processor.getOption(),"Afrikaans");
        assertEquals(processor1.getOption(),"Joey");
        assertEquals(processor2.getOption(),null);
    }
}