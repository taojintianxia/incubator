package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class Test {
	public static void main(String... args) throws Exception {
		final Map<String, List<String>> testMap = new ConcurrentHashMap<>();
		final Random random = new Random();
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					List<String> a = testMap.get("A");
					if (a == null) {
						a = new ArrayList<String>();
					}
					a.add(random.nextDouble() + "");
					testMap.put("A", a);
				}
			}

		}).start();
		Thread.sleep(2000);
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					List<String> a = new ArrayList<String>(testMap.get("A"));
					for (String str : a) {
						System.out.println(str);
					}
					a.clear();
				}
			}

		}).start();
	}

}
