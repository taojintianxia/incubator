package test;

import java.util.HashMap;
import java.util.Map;

public class Test {
	public static void main(String... args) {
		Map<String , String> testMap = new HashMap<>(1,0.01f);
		Map<String , String> testMap2 = new HashMap<>();
		long start  = System.nanoTime();
		for(int i = 0 ; i < 1000000 ;i++){
			testMap.put("i"+i, i+"");
		}
		
		System.out.println(System.nanoTime()-start);
		
		
		long start2  = System.nanoTime();
		for(int i = 0 ; i < 1000000 ;i++){
			testMap2.put("i"+i, i+"");
		}
		
		System.out.println(System.nanoTime()-start2);
	}
}
