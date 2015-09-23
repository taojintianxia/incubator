package fastjson;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;

import model.User;


public class FastJsonDemo {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	
//	public static final Object parse(String text); // 把JSON文本parse为JSONObject或者JSONArray 
//	public static final JSONObject parseObject(String text)； // 把JSON文本parse成JSONObject    
//	public static final  T parseObject(String text, Class clazz); // 把JSON文本parse为JavaBean 
//	public static final JSONArray parseArray(String text); // 把JSON文本parse成JSONArray 
//	public static final  List parseArray(String text, Class clazz); //把JSON文本parse成JavaBean集合 
//	public static final String toJSONString(Object object); // 将JavaBean序列化为JSON文本 
//	public static final String toJSONString(Object object, boolean prettyFormat); // 将JavaBean序列化为带格式的JSON文本 
//	public static final Object toJSON(Object javaObject); 将JavaBean转换为JSONObject或者JSONArray。
	
	@Test
	public void testJsonTransfer(){
		User user = new User();
		user.setAge(11);
		user.setPassword("abc");
		user.setUsername("kkk");
		
		logger.info(JSON.toJSONString(user));
	}

}
