package telran.util.test;

import static org.junit.jupiter.api.Assertions.*;
import telran.util.SortedSet;

import org.junit.jupiter.api.*;


import telran.util.Set;

public abstract class SortedSetTest extends SetTest {
	SortedSet<Integer> sortedSet;
	@BeforeEach
	@Override
	void setUp() {
		super.setUp();
		sortedSet = (SortedSet<Integer>) set;
	}
	@Override
	protected Integer[] getActual (Integer[] array, int size) {
		//System.out.println("Sorted test");
		return array;
	}
	@Test
	void firstTest() {
		//SortedSet<Integer> sortedSet = (SortedSet<Integer>)set;
		assertEquals(-20, sortedSet.first());		
	}
	@Test
	void lastTest() {
		//SortedSet<Integer> sortedSet = (SortedSet<Integer>) set;
		assertEquals(100, sortedSet.last());
	}
	@Test
	void ceilingTest() {
		//SortedSet<Integer> sortedSet = (SortedSet<Integer>) set;
		assertThrowsExactly(NullPointerException.class, () -> sortedSet.ceiling(null));		
		assertEquals(-20, sortedSet.ceiling(-25));
		assertEquals(7, sortedSet.ceiling(7));
		assertEquals(10, sortedSet.ceiling(8));
		assertEquals(10, sortedSet.ceiling(10));
		assertEquals(30, sortedSet.ceiling(28));
		assertEquals(100, sortedSet.ceiling(100));
		assertEquals(100, sortedSet.ceiling(100));
		assertEquals(100, sortedSet.ceiling(90));
		assertEquals(null, sortedSet.ceiling(110));
	}
	@Test
	void floorTest() {
		//SortedSet<Integer> sortedSet = (SortedSet<Integer>) set;
		assertThrowsExactly(NullPointerException.class, () -> sortedSet.floor(null));		
		assertEquals(50, sortedSet.floor(70));
		assertEquals(30, sortedSet.floor(40));
		assertEquals(10, sortedSet.floor(12));
		assertEquals(7, sortedSet.floor(8));
		assertEquals(-20, sortedSet.floor(0));
		assertEquals(100, sortedSet.floor(100));
		assertEquals(100, sortedSet.floor(101));
		assertEquals(50, sortedSet.floor(50));
		assertEquals(30, sortedSet.floor(40));
		assertEquals(null, sortedSet.floor(-40));
	}
}
