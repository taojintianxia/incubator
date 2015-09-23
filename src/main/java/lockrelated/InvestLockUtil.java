package lockrelated;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class InvestLockUtil {

	public static int targetNum = 0;

	private final static int listSize = 10;

	private static ReentrantLock investLock = new ReentrantLock(true);

	private static Map<Integer, ReentrantLock> investLockMap = new ConcurrentHashMap<Integer, ReentrantLock>();

	static {
		for (int i = 0; i < listSize; i++) {
			ReentrantLock investLock = new ReentrantLock(true);
			investLockMap.put(i, investLock);
		}
	}

	public static ReentrantLock getInvestLock() {
		return investLock;
	}

	public static void setInvestLock(ReentrantLock investLock) {
		InvestLockUtil.investLock = investLock;
	}

	public static int getTargetNum() {
		return targetNum;
	}

	public static void setTargetNum(int targetNum) {
		InvestLockUtil.targetNum = targetNum;
	}

	public static boolean tryGetInvestLock() {
		try {
			return investLock.tryLock(8, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			return false;
		}
	}

	public static boolean tryGetInvestLock(int userId) {

		try {
			int position = userId % listSize;
			return investLockMap.get(position).tryLock(8, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			return false;
		}
	}

	public static void releaseInvestLock() {
		if (investLock.isLocked() && investLock.getHoldCount() != 0) {
			investLock.unlock();
		} else {
			System.out.println("不能释放锁");
		}
	}

	public static void releaseInvestLock(int userId) {
		int postion = userId % listSize;
		if (investLockMap.get(postion).isLocked() && investLockMap.get(postion).getHoldCount() != 0) {
			investLockMap.get(postion).unlock();
		} else {
			System.out.println("不能释放锁");
		}
	}
}
