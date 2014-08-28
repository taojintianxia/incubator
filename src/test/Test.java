package test;

public class Test {

	/**
	 * 水仙花数是指一个N位正整数（N>=3），它的每个位上的数字的N次幂之和等于它本身。例 如：153 = 1的三次方 + 5的三次方 + 3的三次方。
	 * 本题要求编写程序,计算所有N位水仙花数。
	 * 
	 * 输入格式： 输入在一行中给出一个正整数N（3<=N<=7）。
	 * 
	 * 输出格式： 按递增顺序输出所有N位水仙花数，每个数字占一行。
	 * 
	 * 输入样例： 3
	 * 
	 * 输出样例： 153 370 371 407
	 * 
	 * @author kane.sun
	 * 
	 */

	public static void main(String... args) {
		Test test = new Test();
		test.printShuiXian(3);
	}

	public void printShuiXian(int range) {
		int start = (int) Math.pow(10, range - 1);
		int end = (int) Math.pow(10, range);

		for (int i = start; i < end; i++) {
			if (isAShuiXian(i)) {
				System.out.println(i);
			}
		}
	}

	private boolean isAShuiXian(int number) {
		int targetNumber = 0;
		char[] numberArray = String.valueOf(number).toCharArray();
		int range = numberArray.length;
		for (int i = 0; i < range; i++) {
			targetNumber += (int) Math.pow(Integer.parseInt(numberArray[i] + ""), range);
		}

		return targetNumber == number;
	}
}