package java8.lambda;

/**
 *
 *
 * @author Kane.Sun
 * @version Mar 20, 2014 3:47:15 PM
 * 
 */

@SuppressWarnings("unused")
public class Demo2 {

	public static void main(String[] args) {

		// the traditional way
		Thread newThread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Just a test");
			}
		});

		// lambda way 1
		Thread newThread2 = new Thread(() -> System.out.println("Just a Test"));

		// lambda way 2
		Thread newThread3 = new Thread(Demo2::printSth);
	}

	private static void printSth() {
		System.out.println("Just a test");
	}

}
