package telran.util.test;
import telran.util.HashMap;
import telran.util.Map.Entry;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;

public class HashMapTest extends MapTest {
	@BeforeEach
	@Override
	void setUp() {
		map = new HashMap<>();
		super.setUp();
	}
	@Override
	protected String[] getKeysActual(String[] keys) {
		Arrays.sort(keys);
		return keys;
	}

	@Override
	protected Entry<String, Integer>[] getEntriesActual(Entry<String, Integer>[] entries) {
		Arrays.sort(entries);
		return entries;
	}
	
}
