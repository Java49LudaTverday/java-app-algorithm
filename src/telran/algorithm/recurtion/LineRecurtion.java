package telran.algorithm.recurtion;

public class LineRecurtion {
	public static long factorial(int n) {
		if (n < 0) {
			throw new IllegalArgumentException("Cannot be negative value");
		}
		long res = 1;
		if (n > 1) {
			res = factorial(n - 1) * n;
		}
		return res;
	}

	public static long power(int num, int pow) {
		// a - any number, b - any positive number or zero
		if (pow < 0) {
			throw new IllegalArgumentException("Cannot be negative value");
		}
//		long res = 1;
//		if(b < 0) {
//			res = a * power(a, b - 1);// a^b = a * a^b-1
//		}
//		return res;
		//  HW#18
		// Limitations:
		// 1.no cycles
		// 2. only + / or - for arithmetic operations
//		long res = num;
//		if (num < 0) {
//			num = -num;
//		}
//		if (pow == 1) {
//			res = num;
//		} else {
//			res = sumPower(res, num, pow);
//			if (res < 0 && ((pow & 1) == 0)) {
//				res = -res;
//			}
//			res = res < 0 ? res + num : res - num;
//		}
		
		long res = 1;
		if( pow > 0) {
			res = multiply(num, power(num , pow - 1));
		}
		return res;
	}

	private static long multiply(int a, long b) {
		long res = 0;
		if(b != 0) {
			res = b < 0 ? multiply(-a, -b) : a + multiply(a, b-1);
		}
		return res;
	}

	private static long sumPower(long res, int num, int pow) {
		long resSumNum = 0;
		if (pow > 1) {
			int counter = 1;
			resSumNum = sumNum(res, num, counter);
			res += sumPower(resSumNum, num - 1, pow - 1);
		}
		return res;
	}

	private static long sumNum(long res, int num, int counter) {
		if (num > counter) {
			res += sumNum(res, num, counter + 1);
		}
		return res;
	}

	public static long sum(int[] array) {
		return sum(0, array);
	}

	private static long sum(int firstIndex, int[] array) {
		long sum = 0;
		if (firstIndex < array.length) {
			sum = array[firstIndex] + sum(firstIndex + 1, array);
		}
		return sum;
	}

	public static int[] reverse(int[] array) {

		return reverse(array, 0, array.length - 1);
	}

	private static int[] reverse(int[] array, int left, int right) {
		if (left < right) {
			array[left] = array[left] + array[right];
			array[right] = array[left] - array[right];
			array[left] = array[left] - array[right];
			reverse(array, left + 1, right - 1);
		}
		return array;
	}

	public static long square(int x) {
		// x any number
		// Limitations:
		// 1. no cycles
		// 2. only plus (+) arithmetic
		// 3. no additional functions
		// 4. no static fields
//		if (x < 0) {
//			x = -x;
//		}
//		long res = x;
//		if (x != 0) {
//			res += square(x - 1) + x - 1;
//		}
		long res = 0;
		if(x != 0) {
			// x^2 = (x - 1)^2 + 2x - 1;
			res = x < 0 ? square(-x) : square(x - 1) + x + x - 1 ;
		}		
		return res;
	}
	
	public static boolean isSubstring (String string, String substr) {
		// write function
		// returns true if a given 'substring' is indeed the
		//substring of a given `string`
		/* Challenges: 1. To apply only following methods
		of the class String: charAt(int ind);
		String substring(int ind);
		int length();
		2. No cycles;*/
		//
		boolean res = false;
		if(string.length() >= substr.length()) {
			res = isEqual(string, substr)? true : isSubstring(string.substring(1), substr);
		}
		
		return res;
	}

	private static boolean isEqual(String string, String substr) {
		boolean res = false;
		if(substr.length() == 0) {
			res = true;
		} else if (string.charAt(0) == substr.charAt(0)) {
			res = isEqual(string.substring(1), substr.substring(1)); 
		}
		return false;
	}

	

}
