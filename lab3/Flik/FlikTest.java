import static org.junit.Assert.*;

import org.junit.Test;

public class FlikTest {

    @Test
    public void testIsSameNumber() {
        int a = 1;
        int b = 2;
        assertFalse(Flik.isSameNumber(a, b));

        a = 128;
        b = 128;
        assertTrue(Flik.isSameNumber(a, b));

        a = 129;
        b = 122;
        assertFalse(Flik.isSameNumber(a, b));

        a = 255;
        b = 255;
        assertTrue(Flik.isSameNumber(a, b));
    }
}
