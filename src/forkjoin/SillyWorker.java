package forkjoin;

/**
 * 
 * 
 * @author Kane.Sun
 * @version Feb 28, 2014 4:08:09 PM
 * 
 */

public class SillyWorker {

	public static void main(String[] args) throws Exception {

		int n = 25;

		long start = System.currentTimeMillis();
		FibonacciProblem bigProblem = new FibonacciProblem(n);

		long result = bigProblem.solve();
		System.out.println("it takes time : " + (System.currentTimeMillis() - start));
		System.out.println("Computing Fib number: " + n);
		System.out.println("Computed Result: " + result);

	}

}
