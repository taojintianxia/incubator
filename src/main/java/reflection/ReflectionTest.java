package reflection;

import java.lang.reflect.Field;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import model.User;

public class ReflectionTest {

	private static Logger logger = LoggerFactory.getLogger(ReflectionTest.class);

	@Test
	public void testGetFieldByReflection()
			throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		User user = new User();
		user.setAge(11);
		user.setPassword("aaaaaa");
		user.setUsername("kane");

		logger.info("user name is : " + getObjectPropertyByName(user, "username"));
	}

	public static <T> Object getObjectPropertyByName(T t, String propertyName) {
		if (t == null || StringUtils.isEmpty(propertyName)) {
			return null;
		}

		Field field;
		try {
			field = t.getClass().getDeclaredField(propertyName);
			field.setAccessible(true);
			return field.get(t);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			logger.error("通过反射调用" + t.getClass().getName() + "时出现问题 ", e);

		}
		return null;
	}

}
