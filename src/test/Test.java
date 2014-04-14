package test;

public class Test {
	public static void main(String... args) throws Exception {

		Object str1 = new Object();
		Object str2 = new Object();
		Object str3 = new Object();

		System.out.println(str1.hashCode() == str2.hashCode());
		System.out.println(str1.hashCode() == str3.hashCode());

	}

}
