package telran.util.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import telran.util.*;

class ArrayListTest {
	List<Integer> list;
	Integer[] numbers = { 10, -20, 7, 50, 100, 30 };

	@BeforeEach
	void setUp() {
		list = new ArrayList<>();
		for (int i = 0; i < numbers.length; i++) {
			list.add(numbers[i]);
		}
	}

	@Test
	void testAdd() {
		assertTrue(list.add(numbers[0]));
		assertEquals(numbers.length + 1, list.size());
	}

	@Test
	void testAddIndex() {
		Integer[] expected0_500 = { 500, 10, -20, 7, 50, 100, 30 };
		Integer[] expected0_500_3_700 = { 500, 10, -20, 700, 7, 50, 100, 30 };
		Integer[] expected0_500_3_700_8_300 = { 500, 10, -20, 700, 7, 50, 100, 30, 300 };
		list.add(0, 500);
		runTest(expected0_500);
		list.add(3, 700);
		runTest(expected0_500_3_700);
		list.add(8, 300);
		runTest(expected0_500_3_700_8_300);

	}

	@Test
	void testRemoveIndex() {
		Integer[] expectedNo10 = { -20, 7, 50, 100, 30 };
		Integer[] expectedNo10_50 = { -20, 7, 100, 30 };
		Integer[] expectedNo10_50_30 = { -20, 7, 100 };
		assertEquals(10, list.remove(0));
		runTest(expectedNo10);
		assertEquals(50, list.remove(2));
		runTest(expectedNo10_50);
		assertEquals(30, list.remove(3));
		runTest(expectedNo10_50_30);

	}

	@Test
	void testGetIndex() {
		assertEquals(10, list.get(0));
	}

	@Test
	void testIndexOf() {
		list.add(3, 10);
		assertEquals(0, list.indexOf(10));
		assertEquals(-1, list.indexOf(null));
	}

	@Test
	void testLastIndexOf() {
		list.add(1, 100);
		list.add(4, 100);
		assertEquals(6, list.lastIndexOf(100));
		assertEquals(-1, list.lastIndexOf(null));
	}

// Integer[] numbers = {10, -20, 7, 50, 100, 30};
	@Test
	void testRemovePattern() {
		Integer[] expectedNo7 = { 10, -20, 50, 100, 30 };
		Integer[] expectedNo7_10 = { -20, 50, 100, 30 };
		Integer[] expectedNo7_10_30 = { -20, 50, 100 };		
		Integer no7 = 7;
		Integer no10 = 10;
		Integer no30 = 30;
		assertTrue(list.remove(no7));
		runTest(expectedNo7);
		assertTrue(list.remove(no10));
		runTest(expectedNo7_10);
		assertTrue(list.remove(no30));
		runTest(expectedNo7_10_30);
		Integer no1 = 1;
		assertFalse(list.remove(no1));
	}
	
	@Test
	void testToArray() {
		Integer[] expectedList = {10, -20, 7, 50, 100, 30};
		Integer[] expectedSpareSize = {10, -20, 7, 50, 100, 30, null};
		
		Integer[]arrListSize = new Integer[list.size()];
		Integer[] arrLessSize = new Integer[list.size()-1];
		Integer[] arrSpareSize = new Integer[list.size()+1];
		
//		System.out.print("Array: ");
//	    for(Integer item:arr) {
//	      System.out.print(item+", ");
//	    }
		assertArrayEquals(expectedList, list.toArray(arrListSize));
		assertArrayEquals(expectedList, list.toArray(arrLessSize));
		assertArrayEquals(expectedSpareSize, list.toArray(arrSpareSize));
	}
	@Test
	@Disabled
	void testToArrayExeption() {
		Integer[] expectedList = {10, -20, 7, 50, 100, 30};				
		assertArrayEquals(expectedList, list.toArray(null));
				
	}

	private void runTest(Integer[] expected) {
		int size = list.size();
		Integer[] actual = new Integer[expected.length];

		for (int i = 0; i < size; i++) {
			actual[i] = list.get(i);
		}
		assertArrayEquals(expected, actual);

	}

}
