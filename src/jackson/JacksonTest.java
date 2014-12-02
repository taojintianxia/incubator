package jackson;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

public class JacksonTest {

	@Test
	public void testJavaPOJOToJson() {
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

		System.out.println(targetList);

		ObjectMapper mapper = new ObjectMapper();
		try {
			mapper.writeValue(new File("/Users/kane/Downloads/test.json"),
					targetList);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
