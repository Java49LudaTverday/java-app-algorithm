package telran.performance;

public abstract class PerformanceTest {
	private String testName;
	private int nRuns;
	
	public PerformanceTest (String testName, int nRuns) {
		this.testName = testName;
		this.nRuns = nRuns;
	}
	
	protected abstract void runTest();
	
	public void run() {
		long timeBefore = System.currentTimeMillis();
		for(int i = 0; i < nRuns; i++) {
			runTest();
		}
		long timeAfter = System.currentTimeMillis();
		double resTime = (timeAfter - timeBefore)/1000.0;
		System.out.printf("%nThe test: '%s' Ntimes: %s Seconds: %.3f%n",testName, nRuns, resTime);
	}

}
