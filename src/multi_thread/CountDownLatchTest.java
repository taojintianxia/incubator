package multi_thread;

import java.util.concurrent.CountDownLatch;

/**
 *
 *
 * @author Kane.Sun
 * @version Apr 14, 2014 10:25:56 AM
 * 
 */

public class CountDownLatchTest {
	public void timeTasks(int nThreads) throws InterruptedException {
		final CountDownLatch startGate = new CountDownLatch(1);
		final CountDownLatch endGate = new CountDownLatch(nThreads);

		long start = System.nanoTime();
		System.out.println("start Latch");
		startGate.countDown();
		for (int i = 0; i < nThreads; i++) {
			Thread t = new Thread(new Runnable() {
				public void run() {
					try {
						System.out.println(Thread.currentThread().getName() + " is runnning");
						startGate.await();
					} catch (InterruptedException ignored) {

					} finally {
						endGate.countDown();
					}
				}
			}) {
			};

			t.start();
		}

		endGate.await();
		long end = System.nanoTime();
		System.out.println("Latch is end , it takes time : " + (end - start));
	}

	public static void main(String[] args) throws InterruptedException {
		CountDownLatchTest test = new CountDownLatchTest();
		test.timeTasks(5);
	}
}
