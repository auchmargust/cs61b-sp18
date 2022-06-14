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
		
		assertFalse(offByOne.equalChars('r', 'r'));
		assertFalse(offByOne.equalChars('r', 'a'));
		
	}
	
}
