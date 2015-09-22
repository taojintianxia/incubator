package org.json;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class JacksonTest {

	@Test
	public void testJavaPOJOToJson() {

		UserGroup userGroup = new UserGroup();

		User user1 = new User();
		user1.setAge(11);
		user1.setName("AA");
		user1.setPassword("A_1");

		User user2 = new User();
		user2.setAge(11);
		user2.setName("AA");
		user2.setPassword("A_1");

		List<User> targetList = new ArrayList<>();
		targetList.add(user1);
		targetList.add(user2);

		userGroup.setId("123456");
		userGroup.setPage("10");
		userGroup.setStatus("OK");
		userGroup.setUsers(targetList);

		System.out.println(targetList);

		JSONArray jsonArray = new JSONArray(targetList);
		System.out.println(jsonArray.toString());
	}
}
