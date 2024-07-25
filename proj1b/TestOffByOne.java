import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    // Uncomment this class once you've created your
    // CharacterComparator interface and OffByOne class. *
    @Test
    public void testEqualChars() {
        assertTrue(offByOne.equalChars('a', 'a'));
        assertTrue(offByOne.equalChars('b', 'b'));
        assertTrue(offByOne.equalChars('.', '.'));
        assertTrue(offByOne.equalChars('好', '好'));
        assertFalse(offByOne.equalChars('!', '@'));
        assertFalse(offByOne.equalChars('b', 'a'));
        assertFalse(offByOne.equalChars('A', 'a'));
        assertFalse(offByOne.equalChars('c', 'C'));
    }
}
