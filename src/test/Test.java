package test;

import java.util.concurrent.CountDownLatch;

public class Test {

	public static void main(String... args) {
		Test test = new Test();
		System.out.println(test.executeB());
	}

	public int executeA() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return 50;
	}

	public int executeB() {
		CountDownLatch latch = new CountDownLatch(2);
		int tmp = 10;
		final flagClass flass = new flagClass();

		new Thread(new Runnable() {
			@Override
			public void run() {
				flass.setFlag(executeA());
				latch.countDown();
				latch.countDown();
			}
		}).start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(6000);
					latch.countDown();
					latch.countDown();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();

		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return flass.getFlag();
	}
}

class flagClass {
	private volatile int flag = 0;

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}
}
