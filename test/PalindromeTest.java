import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import mihajlovic.jelena.Palindrome;

public class PalindromeTest {

    Palindrome p = new Palindrome();

    @Test
    public void testIsPalindrome() {
	assertTrue(p.isPalindrome(1234321));
	assertTrue(p.isPalindrome(1234554321));
	assertTrue(p.isPalindrome(33));
	assertTrue(p.isPalindrome(9));
	assertTrue(p.isPalindrome(0));

	assertFalse(p.isPalindrome(1234564321));
	assertFalse(p.isPalindrome(12345));
	assertFalse(p.isPalindrome(12));
    }

    @Test
    public void testIsPalindromeUsingStringBuilder() {
	assertTrue(p.isPalindromeUsingStringBuilder(1234321));
	assertTrue(p.isPalindromeUsingStringBuilder(1234554321));
	assertTrue(p.isPalindromeUsingStringBuilder(33));
	assertTrue(p.isPalindromeUsingStringBuilder(9));
	assertTrue(p.isPalindromeUsingStringBuilder(0));

	assertFalse(p.isPalindromeUsingStringBuilder(1234564321));
	assertFalse(p.isPalindromeUsingStringBuilder(12345));
	assertFalse(p.isPalindromeUsingStringBuilder(12));
    }

    @Test
    public void testIsPalindromeRecursive() {
	assertTrue(p.isPalindromeRecursive(1234321));
	assertTrue(p.isPalindromeRecursive(1234554321));
	assertTrue(p.isPalindromeRecursive(33));
	assertTrue(p.isPalindromeRecursive(9));
	assertTrue(p.isPalindromeRecursive(0));

	assertFalse(p.isPalindromeRecursive(1234564321));
	assertFalse(p.isPalindromeRecursive(12345));
	assertFalse(p.isPalindromeRecursive(12));
    }
}
