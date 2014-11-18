package java8.lambda.defaultmethod.demo1;

/**
 *
 *
 * @author Kane.Sun
 * @version Apr 28, 2014 2:10:13 PM
 * 
 */

public interface DefaultMethodInterface {

	public void saySth();

	default public void testMethod() {
		System.out.println("Just a test");
	}

}
