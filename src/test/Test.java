package test;

public class Test {
	public static void main(String... args) {
		String num1 = "158745651616161658161651561666561";
		String num2 = "858745464654646546464654646466546";

		System.out.println(addBigNum(num1, num2));
	}

	public static String addBigNum(String num1, String num2) {
		String finalNum = "";
		boolean isOverTen = false;
		int maxLength = num1.length() > num2.length() ? num1.length() : num2.length();

		int tmpSum = 0;
		char[] numArray1 = num1.toCharArray();
		char[] numArray2 = num2.toCharArray();

		if (num1.length() > num2.length()) {
			numArray2 = fillTheCharWithZero(num2.toCharArray(), num1.length());
		} else {
			numArray1 = fillTheCharWithZero(num1.toCharArray(), num2.length());
		}

		for (int i = maxLength - 1; i >= 0; i--) {
			tmpSum = Integer.parseInt(numArray1[i] + "") + Integer.parseInt(numArray2[i] + "");
			if (isOverTen) {
				++tmpSum;
			}

			if (tmpSum > 9) {
				finalNum += String.valueOf(tmpSum).toCharArray()[1];
				isOverTen = true;
			} else {
				finalNum += tmpSum;
				isOverTen = false;
			}
		}

		if (isOverTen) {
			finalNum += "1";
		}

		return revertTheString(finalNum);
	}

	private static char[] fillTheCharWithZero(char[] targetChar, int length) {
		int targetLength = targetChar.length;
		if (targetLength >= length) {
			return targetChar;
		} else {
			char[] zeroChar = new char[length - targetLength];
			for (int i = 0; i < zeroChar.length; i++) {
				zeroChar[i] = '0';
			}
			return (String.valueOf(zeroChar) + String.valueOf(targetChar)).toCharArray();
		}
	}

	private static String revertTheString(String str) {
		char[] targetChar = str.toCharArray();
		String finalString = "";
		for (int i = targetChar.length - 1; i >= 0; i--) {
			finalString += String.valueOf(targetChar[i]);
		}

		return finalString;
	}

}
