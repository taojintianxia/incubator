package logger;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogbackDemo {
	// 定义logger
	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Test
	public void testPrintLog() {
		logger.info("just a info test");
		logger.error("just a error test");
	}
}
