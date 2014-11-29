package test;

public class JavaTest {
	public static void main(String... args) {

		JavaTest testclass = new JavaTest();

		for (int i = 0; i < 50; i++) {
			new Thread(new Runnable() {

				@Override
				public void run() {
					testclass.test();
				}

			}).start();
		}
	}

	public void test() {
		// 这个方法就是你要调用的
		for (int i = 0; i < 5; i++) {
			System.out.println("testing " + Thread.currentThread().getName());
		}

		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
