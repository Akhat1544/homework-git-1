import homeWorkGit.HelloWorld;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestHelloWorld {

    @Test
    void printMethod_shouldReturnHelloWorld(){
        String expected = "hello world";

        String actual = HelloWorld.printMethod();

        assertEquals(expected, actual);
    }
}
