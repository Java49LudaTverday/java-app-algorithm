package telran.memoryServiceTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

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
	
	@Test
	void allocationMemoryTestWithGC() {
		Runtime runtime = Runtime.getRuntime();
		for(int i = 0; i<10; i++) {
			displayMemoryMap(runtime);
		 long freeMemory = runtime.freeMemory();
		 int size = freeMemory > Integer.MAX_VALUE ? Integer.MAX_VALUE :(int) freeMemory;
		 byte[] array = new byte[size];
		}
	}
	
	@Test
	void allocationMemoryTestNoGC () {
		List<byte[]> list = new ArrayList<>();
		Runtime runtime = Runtime.getRuntime();
		try {
			while(true) {
				displayMemoryMap(runtime);
				 long freeMemory = runtime.freeMemory();
				 int size = freeMemory > Integer.MAX_VALUE ? Integer.MAX_VALUE :(int) freeMemory;
				list.add(new byte[size]);
			}
		} catch (OutOfMemoryError e) {
			
		}
	}

	private void displayMemoryMap(Runtime runtime) {
		System.out.printf("free memory: %d, total memory: %d, maximal memory: %d\n", runtime.freeMemory(), runtime.totalMemory(), runtime.maxMemory());
		
	}

}
