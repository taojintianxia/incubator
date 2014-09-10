package test;

import java.util.LinkedHashMap;
import java.util.Map;

public class Test {
	public static void main(String... args) {
		Map<String, String> test = new LinkedHashMap<>();
		test.put("AA", "AAA");
		test.put("BB", "BBB");
		test.put("AA", "CCC");

		for (Map.Entry<String, String> entry : test.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
	}
}