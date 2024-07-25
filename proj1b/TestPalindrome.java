import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    } // Uncomment this class once you've created your Palindrome class.

    @Test
    public void testIsPalindrome() {
        assertFalse(palindrome.isPalindrome("Cat"));
        assertFalse(palindrome.isPalindrome("Dog"));
        assertFalse(palindrome.isPalindrome("Heeh"));
        assertTrue(palindrome.isPalindrome("a"));
        assertTrue(palindrome.isPalindrome("wow"));
        assertTrue(palindrome.isPalindrome("racecar"));
        assertTrue(palindrome.isPalindrome("noon"));
        assertFalse(palindrome.isPalindrome("horse"));


        OffByOne offByOne = new OffByOne();
        assertTrue(palindrome.isPalindrome("ab", offByOne));
        assertTrue(palindrome.isPalindrome("ba", offByOne));
        assertTrue(palindrome.isPalindrome("acb", offByOne));
        assertFalse(palindrome.isPalindrome("%abca&", offByOne));
        assertFalse(palindrome.isPalindrome("wow", offByOne));
        assertFalse(palindrome.isPalindrome("racecar", offByOne));
        assertFalse(palindrome.isPalindrome("noom", offByOne));
        assertFalse(palindrome.isPalindrome("horse", offByOne));
        assertFalse(palindrome.isPalindrome("horse", offByOne));
        assertFalse(palindrome.isPalindrome("Ab", offByOne));
        assertFalse(palindrome.isPalindrome("aB", offByOne));
        assertFalse(palindrome.isPalindrome("aBC", offByOne));
        assertFalse(palindrome.isPalindrome("Cda", offByOne));
        assertTrue(palindrome.isPalindrome("", offByOne));
        assertTrue(palindrome.isPalindrome("a", offByOne));
        
        OffByN offBy5 = new OffByN(5);
        assertTrue(palindrome.isPalindrome("binding", offBy5));
    }

}
