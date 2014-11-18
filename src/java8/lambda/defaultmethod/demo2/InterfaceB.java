package java8.lambda.defaultmethod.demo2;

/**
 *
 *
 * @author Kane.Sun
 * @version Apr 28, 2014 2:17:31 PM
 * 
 */

public interface InterfaceB extends InterfaceA {
	default void saySth() {
		System.out.println("This is B");
	}
}
