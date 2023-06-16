package telran.util.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import telran.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import telran.util.Map;

class MapTest {

	String[] keys = { "lmn", "abc", "ab", "a" };
	Integer[] values = { 3, 2, 2, 1 };
	protected Map<String, Integer> map;

	@BeforeEach
	void setUp() {
		for (int i = 0; i < keys.length; i++) {
			map.put(keys[i], values[i]);
		}
	}

	@Test
	void getTest() {
		for (int i = 0; i < keys.length; i++) {
			assertEquals(values[i], map.get(keys[i]));
		}
	}

	@Test
	void containsKeyTest() {
		assertThrowsExactly(NullPointerException.class,()-> map.containsKey(null));
		assertTrue(map.containsKey(keys[0]));
		assertTrue(map.containsKey(keys[2]));
		assertTrue(map.containsKey(keys[keys.length - 1]));
		assertFalse(map.containsKey(keys[0]+ "abc"));
		
	}

	@Test
	void containsValueTest() {
		assertThrowsExactly(NullPointerException.class,()-> map.containsValue(null));
		assertTrue(map.containsValue(values[0]));
		assertTrue(map.containsValue(values[2]));
		assertTrue(map.containsValue(values[values.length - 1]));
		assertFalse(map.containsValue(values[0]+1));
	}

	@Test
	void removeTest() {
		assertEquals(values[0], map.remove(keys[0]));
		Integer[] expectedNo3 = {2, 2, 1};
		Collection<Integer> actualNo3 = map.values();
		runArrayEqualsTest(expectedNo3, actualNo3.toArray(new Integer[values.length]));
		assertEquals(values[values.length-1], map.remove(keys[values.length-1]));
		Integer[] expectedNo3_No1 = {2, 2};
		Collection<Integer> actualNo3_No1 = map.values();
		runArrayEqualsTest(expectedNo3_No1, actualNo3_No1.toArray(new Integer[values.length]));
		
		assertEquals(null, map.remove(keys[0]+keys[1]));
		
	}

	@Test
	void collectionValuesTest() {
		Collection<Integer> collec = map.values();
		runArrayEqualsTest(values, collec.toArray(new Integer[values.length]));
	}

	private void runArrayEqualsTest(Integer[] values, Integer[] array) {
		Integer[] valCopy = Arrays.copyOf(values, values.length);
		Arrays.sort(valCopy);
		Integer[] arrayCopy = Arrays.copyOf(array, values.length);
		Arrays.sort(arrayCopy);
		assertArrayEquals(valCopy, arrayCopy);
	}

}
