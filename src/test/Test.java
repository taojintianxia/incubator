package test;

public class Test {

	public static void main(String... args) throws Exception {
		Test test = new Test();
		Test test2 = new Test();
		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					test.methodA();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}).start();

		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					test.methodB();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}).start();

	}

	public synchronized void methodA() throws Exception {
		for (int i = 0; i < 10; i++) {
			System.out.println("A is calling");
			Thread.sleep(200);
		}
	}

	public synchronized void methodB() throws Exception {
		for (int i = 0; i < 10; i++) {
			System.out.println("B is calling");
			Thread.sleep(200);
		}
	}

}
