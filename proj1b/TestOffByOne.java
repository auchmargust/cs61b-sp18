import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestOffByOne {
	
	// You must use this CharacterComparator and not instantiate
	// new ones, or the autograder might be upset.
	static CharacterComparator offByOne = new OffByOne();
	
	@Test
	public void testOffByOne() {
		assertTrue(offByOne.equalChars('a', 'b'));
		assertTrue(offByOne.equalChars('r', 'q'));
		assertTrue(offByOne.equalChars('A', 'B'));
		assertTrue(offByOne.equalChars('b', 'A'));
		
		assertFalse(offByOne.equalChars('r', 'r'));
		assertFalse(offByOne.equalChars('r', 'a'));
		assertFalse(offByOne.equalChars('R', 'a'));
		
		assertFalse(offByOne.equalChars('%', 'a'));
		assertFalse(offByOne.equalChars('%', '/'));
		assertFalse(offByOne.equalChars('%', '%'));
		assertFalse(offByOne.equalChars('%', 'F'));
	}
	
	@Test
	public void testOffByN() {
		CharacterComparator obn = new OffByN(5);
		assertTrue(obn.equalChars('a', 'f'));
		assertTrue(obn.equalChars('A', 'F'));
		assertTrue(obn.equalChars('F', 'a'));
		
		assertFalse(obn.equalChars('r', 'r'));
		assertFalse(obn.equalChars('r', 'a'));
		assertFalse(obn.equalChars('R', 'a'));
		
		assertFalse(obn.equalChars('%', 'a'));
		assertFalse(obn.equalChars('%', '/'));
		assertFalse(obn.equalChars('%', '%'));
		assertFalse(obn.equalChars('%', 'F'));
	}
	
}
