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
    }

    @Test
    public void testIsPalindrome() {
        boolean b1 = palindrome.isPalindrome("tenet");
        boolean b2 = palindrome.isPalindrome("Tenet");
        boolean b3 = palindrome.isPalindrome("a");
        boolean b4 = palindrome.isPalindrome("");
        assertEquals(true, b1);
        assertEquals(false, b2);
        assertEquals(true, b3);
        assertEquals(true, b4);
    }

    @Test
    public void testIsPalindromeOffByOne() {
        OffByOne offByOne = new OffByOne();
        boolean b1 = offByOne.isPalindrome("tenet");
        boolean b2 = offByOne.isPalindrome("detrude");
        boolean b3 = offByOne.isPalindrome("a");
        boolean b4 = offByOne.isPalindrome(" ");
        assertEquals(false, b1);
        assertEquals(true, b2);
        assertEquals(true, b3);
        assertEquals(true, b4);
    }

    @Test
    public  void testIsPalindromeCC() {
        CharacterComparator cc = new OffByN(5);
        boolean b1 = palindrome.isPalindrome("tenet", cc);
        boolean b2 = palindrome.isPalindrome("binding", cc);
        boolean b3 = palindrome.isPalindrome("This", cc);
        assertEquals(false, b1);
        assertEquals(true, b2);
        assertEquals(false, b3);
    }
}
