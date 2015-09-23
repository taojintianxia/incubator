package test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JavaTest {
	// 定义logger
	private final Logger logger = LoggerFactory.getLogger(getClass());

	public static void main(String... args) {
		JavaTest test = new JavaTest();
		test.logger.info("just a info test");
		test.logger.error("just a error test");
	}
}
