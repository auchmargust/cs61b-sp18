package synthesizer;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests the ArrayRingBuffer class.
 *
 * @author Josh Hug
 */

public class TestArrayRingBuffer {
	@Test
	public void someTest() {
		ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<>(10);
//		arb.enqueue(1);
//		arb.enqueue(2);
//		arb.enqueue(3);
//		arb.enqueue(4);
//		arb.enqueue(5);
//		arb.enqueue(6);
//		int i = 1;
//		for (int j = 0; j < arb.fillCount(); j++) {
//			Assert.assertEquals(j + 1, i);
//			i = i + 1;
//		}
		
		
		for (int i = 0; i < arb.capacity(); i++) {
			arb.enqueue(i);
		}
		Assert.assertTrue(arb.isFull());
		int x = 0;
		for (int j = 0; j < arb.fillCount(); j++) {
			Assert.assertEquals(j, x);
			x = x + 1;
		}
	}
	
	/**
	 * Calls tests for ArrayRingBuffer.
	 */
	public static void main(String[] args) {
		jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
	}
}
