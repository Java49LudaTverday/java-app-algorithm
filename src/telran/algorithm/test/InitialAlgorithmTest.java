package telran.algorithm.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.algorithm.InitialAlgorithm;

class InitialAlgorithmTest {

//	short[] randomArray = new short[10];
//
//	@BeforeEach
//	
//	void getRandomArray() {
//		for (int i = 0; i < randomArray.length; i++) {
//			randomArray[i] = (short) (Math.random() * Short.MAX_VALUE);
//		}
//	}

	@Test
	void testGetMaxPositiveWithNegativeReflect() {
		short[] numbers = { -50, -20, 7, 10, 30, 20, 50, 100, 0 };
		assertEquals(50, InitialAlgorithm.getMaxPositiveWithNegativeReflect(numbers));

		short[] numbersNoMatches_Neg = { 0, -1, -2, -3, -4, -5 };
		assertEquals(-1, InitialAlgorithm.getMaxPositiveWithNegativeReflect(numbersNoMatches_Neg));

		short[] numbersNoMatches_Pos = { 1, 2, 3, 4, 5 };
		assertEquals(-1, InitialAlgorithm.getMaxPositiveWithNegativeReflect(numbersNoMatches_Pos));

	}

	@Test
	void testIsSum2() {
		short[] numbers = { 0, 5, 1, 3, 2, 4 };
		assertTrue(InitialAlgorithm.isSum2(numbers, (short) 5));

		short[] numbersNoSum = { 0, 1, 2, 3, 4, 5 };
		assertFalse(InitialAlgorithm.isSum2(numbersNoSum, (short) 0));

		short[] numbersSumZero = { 0, 1, 2, 3, 4, 0 };
		assertTrue(InitialAlgorithm.isSum2(numbersSumZero, (short) 0));

		short[] numbersMiddleSum = { 8, 1, 2, 3, 3 };
		assertTrue(InitialAlgorithm.isSum2(numbersMiddleSum, (short) 6));
	}

	@Test
	void testBubbleSort() {
		short[] randomArray = getRandomArray(10000);
		InitialAlgorithm.bubbleSort(randomArray);
		assertTrue(runSortedAscendingArrayTest(randomArray));
	}

	@Test
	void testSortShortPositive() {
		short[] randomArray = getRandomArray(1000000);
		InitialAlgorithm.sortShortPositive(randomArray);
		assertTrue(runSortedAscendingArrayTest(randomArray));
	}

	private boolean runSortedAscendingArrayTest(short[] array) {
		int counter = 0;
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i] > array[i + 1]) {
				counter++;
			}
		}

		return counter == 0;

	}

	private short[] getRandomArray(int size) {
		short[] randomArray = new short[size];
		for (int i = 0; i < randomArray.length; i++) {
			randomArray[i] = (short) (Math.random() * Short.MAX_VALUE);
		}
		return randomArray;
	}

}
