package telran.util.test;
import telran.util.*;
import telran.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HashMapTest extends MapTest {
	@BeforeEach
	@Override
	void setUp() {
		map = new HashMap<>();
		super.setUp();
	}
	
	
}
