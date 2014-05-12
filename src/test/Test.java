package test;

public class Test {

	public static void main(String... args) {
		Test tt = new Test();
		tt.test();
	}

	private void test() {
		System.out.println(this.getClass().getName());
		System.out.println(getClass().getName());
	}

}
