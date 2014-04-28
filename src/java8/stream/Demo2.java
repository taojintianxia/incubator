package java8.stream;

import java.util.stream.IntStream;

/**
 *
 *
 * @author Kane.Sun
 * @version Apr 28, 2014 4:00:05 PM
 * 
 */

@SuppressWarnings("unused")
public class Demo2 {

	public static void main(String... args) {
		long t0 = System.nanoTime();

		// initialize a 1 million number stream , which would be divided exactly

		int a[] = IntStream.range(0, 1_000_000).filter(p -> p % 2 == 0).toArray();

		long t1 = System.nanoTime();

		// this is parallel way

		int b[] = IntStream.range(0, 1_000_000).parallel().filter(p -> p % 2 == 0).toArray();

		long t2 = System.nanoTime();

		System.out.printf("serial: %.2fs, parallel %.2fs%n", (t1 - t0) * 1e-9, (t2 - t1) * 1e-9);
	}

}
