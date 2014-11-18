package lombok;

import org.junit.Test;

public class TestUser {

	private User user;

	@Test
	public void initUser() {
		user = new User();
		user.setAge(11);
		user.setPassword("123123");
		user.setUsername("test");
		System.out.println(user);
	}

}
