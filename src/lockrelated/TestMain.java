package lockrelated;

import java.util.Random;

public class TestMain {

	private static Random random = new Random();

	public static void main(String... args) throws Exception {

		for (int i = 0; i < 100; i++) {
			new Thread(new Runnable() {

				@Override
				public void run() {
					boolean captured = false;
					int userId = random.nextInt(1000);
					try {
						captured = InvestLockUtil.tryGetInvestLock(userId);
						if (!captured) {
							System.out.println("未获得锁");
						} else {
							InvestLockUtil.setTargetNum(InvestLockUtil.getTargetNum() + 1);
						}
					} finally {
						if (captured)
							InvestLockUtil.releaseInvestLock(userId);
					}
				}

			}).start();
		}

		Thread.sleep(2);

		System.out.println(InvestLockUtil.getTargetNum());
		
	}

}
