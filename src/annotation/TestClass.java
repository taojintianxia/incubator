package annotation;

/**
 *
 *
 * @author Kane.Sun
 * @version May 16, 2014 11:14:07 AM
 * 
 */

public class TestClass extends ParentClass {

	public static void main(String... args) {
		TestClass test = new TestClass();
		test.keepOnWorking();
	}

	public void keepOnWorking() {
		System.out.println("aa----");
		super.judgeReturn(true);
		System.out.println("bb----");
	}

}
