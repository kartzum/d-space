package m.d.d.e.p;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FunctionsTests {

    @Test
    void addTest() {
        double c = Functions.add(2, 2);
        assertEquals(4, c);
    }
}