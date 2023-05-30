package telran.util.test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

import org.junit.jupiter.api.Test;

import telran.util.*;


public class TreeSetTest extends SetTest {
   
	@Override
	protected <T> Set<T> getSet() {		
		return new TreeSet<>() ;
	}
	
	@Override
	@Test
	void testIteratorRemove() {
		Iterator<Integer> it = collection.iterator();
		Integer[] expectedLeast = {10, 7, 50, 100, 30 };
		Integer[] expectedMost = {  10, 7, 50, 30 };
		assertThrowsExactly(IllegalStateException.class, ()-> it.remove());
		it.next();
		it.remove();
		runTest(expectedLeast);
		assertEquals(5, collection.size());
		assertThrowsExactly(IllegalStateException.class, ()-> it.remove());
		while(it.hasNext()) {
			it.next();
		}
		it.remove();
		runTest(expectedMost);		
	}

}
