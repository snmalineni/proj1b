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
        assertFalse(palindrome.isPalindrome("cat"));

        assertTrue(palindrome.isPalindrome("catac"));

        assertTrue(palindrome.isPalindrome("x"));

        assertTrue(palindrome.isPalindrome(""));
    }

    @Test
    public void testIsPalindromeWithCharacterComparator() {
        CharacterComparator cc = new OffByOne();

        assertFalse(palindrome.isPalindrome("cat", cc));

        assertTrue(palindrome.isPalindrome("flake", cc));

        assertTrue(palindrome.isPalindrome("x", cc));

        assertTrue(palindrome.isPalindrome("", cc));
    }

    @Test
    public void testIsPalindromeByNWithCharacterComparator() {
        CharacterComparator cc = new OffByN(5);

        assertFalse(palindrome.isPalindrome("cat", cc));

        assertTrue(palindrome.isPalindrome("aMuOzHf", cc));

        assertTrue(palindrome.isPalindrome("x", cc));

        assertTrue(palindrome.isPalindrome("", cc));
    }
}
