package telran.algorithm;

public class MemoryService {
	public static int getMaxAvailableMamorySize() {
		int right = Integer.MAX_VALUE;
		int left = 1;
		int middle = right / 2;
		
		while (left <= right) {
			try {
				byte[] array = new byte[middle]; 
				left = middle + 1;
			} catch (OutOfMemoryError e) {
				right = middle - 1;
			}
			
			middle = (right - left) / 2 + left;
//			middle = right / 2 + left / 2;

		}
		System.out.println("middle:" + middle + " Left:" + left + " Right:" + right);
		return right;
	}
}
