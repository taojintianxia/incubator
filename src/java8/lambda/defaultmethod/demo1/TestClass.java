package java8.lambda.defaultmethod.demo1;

/**
 *
 *
 * @author Kane.Sun
 * @version Apr 28, 2014 2:09:36 PM
 * 
 */

public class TestClass {
	private static class TMPClass implements DefaultMethodInterface {
		@Override
		public void saySth() {
			// do thing
		}
	}

	public static void main(String... args) {
		TMPClass tmpClass = new TMPClass();
		tmpClass.testMethod();
	}

}
