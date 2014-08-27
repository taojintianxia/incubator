package test;

public class Test {

	public static void main(String... args) {
		Test test = new Test();
		test.printShuiXian(3);
	}

	public void printShuiXian(int range) {
		double start = (long) Math.pow(10, range - 1);
		double end = (long) Math.pow(10, range);

		for (double i = start; i < end; i++) {
			if (isItAShuiXian(i, range)) {
				System.out.println((int) i);
			}
		}
	}

	private boolean isItAShuiXian(double number, int range) {
		int shuiXianNumber = 0;
		char[] numberArray = String.valueOf(number).toCharArray();
		for (int i = 0; i < range; i++) {
			shuiXianNumber += (long) Math.pow(Integer.valueOf(numberArray[i] + ""), range);
		}

		return shuiXianNumber == number;
	}
}