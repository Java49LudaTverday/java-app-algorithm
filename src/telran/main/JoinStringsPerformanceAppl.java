package telran.main;

import telran.strings.*;
import telran.performance.*;

public class JoinStringsPerformanceAppl {

	private static final int N_STRINGS = 1000;
	private static final int N_RUNS = 10000;

	public static void main(String[] args) {
		String[] strings = getBigArrayStrings(N_STRINGS);
		JoinStrings joinStringsBuilder = new JoinStringsBuilderImpl();
		JoinStrings joinStrings = new JoinStringsImpl();

		PerformanceTest testJoinStrings = new JoinStringsPerformanceTest("JoinStrings", N_RUNS, strings, joinStrings);
		PerformanceTest testJoinStringsBuilder = new JoinStringsPerformanceTest("JoinStringsBuilder", N_RUNS, strings,
				joinStringsBuilder);

		testJoinStrings.run();
		testJoinStringsBuilder.run();

	}

	private static String[] getBigArrayStrings(int nStrings) {
		String[] res = new String[nStrings];
		for (int i = 0; i < nStrings; i++) {
			res[i] = "Summer";
		}
		return res;
	}

}
