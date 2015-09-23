package forkjoin;

import java.util.concurrent.ForkJoinPool;

/**
 * 
 * 
 * @author Kane.Sun
 * @version Feb 28, 2014 4:22:53 PM
 * 
 */

public class ForkJoinWorker {

	public static void main(String[] args) {

		// Check the number of available processors
		int processors = Runtime.getRuntime().availableProcessors();
		System.out.println("No of processors: " + processors);

		int n = 25;

		long start = System.currentTimeMillis();
		FibonacciProblem bigProblem = new FibonacciProblem(n);

		FibonacciTask task = new FibonacciTask(bigProblem);
		ForkJoinPool pool = new ForkJoinPool(processors);
		pool.invoke(task);

		long result = task.result;
		System.out.println("Computed Result: " + result);

		System.out.println("Elapsed Time: " + (System.currentTimeMillis() - start));

	}

}