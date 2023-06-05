package telran.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import telran.algorithm.recurtion.LineRecurtion;

class LinerRecurtionTest {

	@Test
	@Disabled
	void test() {
		f(6);
	}

	private void f(int a) {
		if(a > 5){
			System.out.println(a);
			f(a - 1);
		}		
	}
	@Test
	void factorialTest () {
		assertEquals(6, LineRecurtion.factorial(3));
		assertEquals(24, LineRecurtion.factorial(4));
		assertEquals(1, LineRecurtion.factorial(0));
	}
	@Test
	void powerTest () {
		assertEquals(10, LineRecurtion.power(10, 1));
		assertEquals(0, LineRecurtion.power(0, 2));
		assertEquals(100, LineRecurtion.power(10, 2));
		assertEquals(100, LineRecurtion.power(-10, 2));
		assertEquals(1000, LineRecurtion.power(10, 3));
		assertEquals(-1000, LineRecurtion.power(-10, 3));
	}
	@Test
	void sumTest() {
		assertEquals(21, LineRecurtion.sum(new int[] {1, 2, 3, 4, 5, 6}));
	}
	@Test
	void reverseTest () {
		int array[] = {1, 2, 3, 4, 5, 6};
		int array1[] = {1, 2, 3, 4, 5, 6, 7};
		int expected[] = {6, 5, 4, 3, 2, 1};
		int expected1[] = {7, 6, 5, 4, 3, 2, 1};
		assertArrayEquals(expected, LineRecurtion.reverse(array));
		assertArrayEquals(expected1, LineRecurtion.reverse(array1));		
	}
	@Test 
	void squareTest(){
		assertEquals(0, LineRecurtion.square(0));
		assertEquals(1, LineRecurtion.square(1));
		assertEquals(9, LineRecurtion.square(3));
		assertEquals(16, LineRecurtion.square(4));
		assertEquals(25, LineRecurtion.square(5));
		assertEquals(25, LineRecurtion.square(-5));
		assertEquals(9, LineRecurtion.square(-3));
	}
	@Test
	void isSubstringTest () {
		assertTrue(LineRecurtion.isSubstring("Hello","lo"));
	}
}
