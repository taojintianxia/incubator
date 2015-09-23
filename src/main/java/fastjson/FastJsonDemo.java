package fastjson;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;

import model.User;


public class FastJsonDemo {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Test
	public void testJsonTransfer(){
		User user = new User();
		user.setAge(11);
		user.setPassword("abc");
		user.setUsername("kkk");
		
		logger.info(JSON.toJSONString(user));
	}

}
