package test;

public class InternInDifferentJVM {
	/*
	 * this app will get two false as result in JDK 6 , but two true in JDK 7
	 * and newer JDK
	 */

	public static void main(String... args) {
		// String str1 = "abc";
		// System.out.println(str1 == str1.intern());

		String str1 = new StringBuilder("計算機").append("軟件").toString();
		System.out.println(str1.intern() == str1);

		String str2 = new StringBuilder("Ja").append("va").toString();
		System.out.println(str2.intern() == str2);

	}

}
