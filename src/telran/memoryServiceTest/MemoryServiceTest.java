package telran.memoryServiceTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import telran.algorithm.MemoryService;

class MemoryServiceTest {
	byte[] array;

	@Test
	void testMemory() {	
		int size = MemoryService.getMaxAvailableMamorySize();
		
		array = new byte[size];
		boolean flException = false;
		try {
			array = null;
			array = new byte[size + 1];
		} catch (OutOfMemoryError e) {
			flException = true;
		}
		
		assertTrue(flException);
	}

}
