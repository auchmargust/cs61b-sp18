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
		// Any word of length 1 or 0 is a palindrome.
		assertTrue(palindrome.isPalindrome("a"));
		assertTrue(palindrome.isPalindrome(""));
		
		assertTrue(palindrome.isPalindrome("noon"));
		assertTrue(palindrome.isPalindrome("Nooon"));
		assertTrue(palindrome.isPalindrome("RACECAR"));
		
		assertFalse(palindrome.isPalindrome("cat"));
	}
	
	@Test
	public void testIPalindromeCc() {
		OffByOne obo = new OffByOne();
		assertTrue(palindrome.isPalindrome("", obo));
		assertTrue(palindrome.isPalindrome("a", obo));
		assertTrue(palindrome.isPalindrome("A", obo));
		
		assertTrue(palindrome.isPalindrome("flake", obo));
		assertTrue(palindrome.isPalindrome("YYXZ", obo));
		
		assertFalse(palindrome.isPalindrome("aa", obo));
		assertFalse(palindrome.isPalindrome("xyz", obo));
		
	}
}
