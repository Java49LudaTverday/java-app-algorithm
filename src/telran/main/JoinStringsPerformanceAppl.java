package telran.main;

import telran.strings.*;

import java.lang.reflect.Constructor;

import telran.performance.*;

public class JoinStringsPerformanceAppl {

	private static final int N_STRINGS = 1000;
	private static final int N_RUNS = 10000;
	private static final String BASE_NAME = "telran.strings.";
//FIXME rewrite the code by applying class reflection
	// to get rid of  JoinString implementation
	@SuppressWarnings("unchecked")
	public static void main(String[] args)  {
		String[] strings = getBigArrayStrings(N_STRINGS);
		if(args.length < 1) {
			System.out.println("Too low number of args");
		} else {
			for(String arg: args) {
			try {
				Class<JoinStrings> clazz = (Class<JoinStrings>) Class.forName(BASE_NAME + arg);
				Constructor<JoinStrings> constructor = clazz.getConstructor();
				JoinStrings joinString = constructor.newInstance();
				PerformanceTest testJoinStrings = new JoinStringsPerformanceTest(arg, N_RUNS, strings, joinString );
				testJoinStrings.run();
				
			} catch (ClassNotFoundException e) {
				System.out.println(e.getMessage());
			} catch (Exception e) {
				e.printStackTrace();
			}			
			}
		}

	}

	private static String[] getBigArrayStrings(int nStrings) {
		String[] res = new String[nStrings];
		for (int i = 0; i < nStrings; i++) {
			res[i] = "Summer";
		}
		return res;
	}

}
