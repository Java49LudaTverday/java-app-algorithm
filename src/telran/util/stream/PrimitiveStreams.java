package telran.util.stream;

import java.util.Random;

import telran.util.ArrayList;

public class PrimitiveStreams {
	public static int[] randomUnique(int nNumbers, int minInclusive, int maxExclusive) {
		if(maxExclusive - minInclusive < nNumbers) {
			throw new IllegalArgumentException("impossible to get the given amount of unique random numbers");
		}
		return new Random().ints(minInclusive, maxExclusive)
				.distinct().limit(nNumbers).toArray();
	}
	//Version 1:
	public static int[] shuffle (int[] array) {
		return  new Random().ints(0, array.length).distinct()
				.limit(array.length).map(a -> array[a])				
				.toArray();
	}
	
	//Version 2:
//	public static int[] shuffle (int[] array) {
//		ArrayList<Integer> arrayInt = new ArrayList<>();
//		new Random().ints(0, array.length).distinct().limit(array.length)
//		.forEach(n -> arrayInt.add(array[n]));
//		
//		return 	arrayInt.stream().mapToInt(n -> n).toArray();		
//	}
	
}
