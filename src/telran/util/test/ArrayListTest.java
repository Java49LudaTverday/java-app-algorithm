package telran.util.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import telran.util.ArrayList;

class ArrayListTest {
	ArrayList<Integer> numbers = new ArrayList<>();
	ArrayList<String> strings = new ArrayList<>();

	@Test
	void test() {
		numbers.add(1);
		numbers.add(2);

		strings.add("ABC");
		assertEquals(2, numbers.size());
		assertEquals(1, strings.size());

		numbers.add(0, 100);
		assertEquals(3, numbers.size());
		numbers.add(numbers.size(), 200);
		assertEquals(4, numbers.size());

		for (int i = 0; i < 12; i++) {
			numbers.add(i, i + 1000);
		}
		assertEquals(16, numbers.size());
		numbers.add(numbers.size(), 1);
		assertEquals(17, numbers.size());
	}
	@Test
	//@Disabled
	void testAddElemBoundOfIndex () {
		for (int i = 0; i < 10; i++) {
			numbers.add(i, i + 1000);
		}
		numbers.add(-1, 5);
		int expected10 = 10;
		assertEquals(expected10, numbers.size());
		numbers.add(numbers.size()+1,8);
		assertEquals(expected10, numbers.size());
	}

	@Test
	void testRemoveElem() {
		for (int i = 0; i < 10; i++) {
			numbers.add(i, i + 1000);
		}
		numbers.remove(9);
		assertEquals(9, numbers.size());
		int remuvedNum = numbers.remove(0);
		assertEquals(8, numbers.size());
		assertEquals(1000, remuvedNum);
	}
	@Test
	@Disabled
	void testRemoveElemBoundOfIndex () {
		for (int i = 0; i < 11; i++) {
			numbers.add(i, i + 1000);
		}
		int expectedNull = 0;
		assertEquals(expectedNull, numbers.remove(-1));
		assertEquals(expectedNull, numbers.remove(numbers.size()));
	}
	
	@Test
	void testGetElem() {
		for (int i = 0; i < 11; i++) {
			numbers.add(i, i + 1000);
		}
		int expected1000 = 1000;
		int expected1010 =1010 ;
		int expected1005 = 1005 ;
		assertEquals(expected1000, numbers.get(0));
		assertEquals(expected1010, numbers.get(numbers.size() - 1));
		assertEquals(expected1005, numbers.get(5));
	}
	@Test
	@Disabled
	void testGetElemBoundOfIndex () {
		for (int i = 0; i < 11; i++) {
			numbers.add(i, i + 1000);
		}
		int expected1000 = 1000;
		assertEquals(expected1000, numbers.get(-1));
		assertEquals(expected1000, numbers.get(numbers.size()));
	}
			

}
