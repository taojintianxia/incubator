package com.github.taojintianxia.incubator.fastjson;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.alibaba.fastjson.JSON;

import lombok.extern.slf4j.Slf4j;
import model.User;

@Slf4j
public class FastJsonDemo {

    // public static final Object parse(String text); //
    // 把JSON文本parse为JSONObject或者JSONArray
    // public static final JSONObject parseObject(String text)； //
    // 把JSON文本parse成JSONObject
    // public static final T parseObject(String text, Class clazz); //
    // 把JSON文本parse为JavaBean
    // public static final JSONArray parseArray(String text); //
    // 把JSON文本parse成JSONArray
    // public static final List parseArray(String text, Class clazz);
    // //把JSON文本parse成JavaBean集合
    // public static final String toJSONString(Object object); //
    // 将JavaBean序列化为JSON文本
    // public static final String toJSONString(Object object, boolean
    // prettyFormat); // 将JavaBean序列化为带格式的JSON文本
    // public static final Object toJSON(Object javaObject);
    // 将JavaBean转换为JSONObject或者JSONArray。

    @Test
    public void testJsonTransfer() {
        User user = new User();
        user.setAge(11);
        user.setPassword("abc");
        user.setUsername("kkk");

        Map<String, User> userMap = new HashMap<>();
        userMap.put("kkk", user);

        log.info(JSON.toJSONString(userMap));
    }

    @SuppressWarnings("unchecked")
    @Test
    public void parseWithSpecificClazz() {
        String jsonStr = "{\"kkk\":{\"age\":11,\"password\":\"abc\",\"username\":\"kkk\"}}";
        Map<String, String> userMap = new HashMap<>();
        userMap = JSON.parseObject(jsonStr, userMap.getClass());
        for (Object o : userMap.entrySet()) {
            Map.Entry<String, Object> entry = (Map.Entry<String, Object>) o;
            System.out.println(
                    entry.getKey() + " : " + JSON.parseObject(entry.getValue().toString(), User.class).getUsername());
        }
    }

}
