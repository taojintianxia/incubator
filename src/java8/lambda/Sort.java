package java8.lambda;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 *
 * @author Kane.Sun
 * @version Apr 15, 2014 10:38:33 AM
 * 
 */

public class Sort {

	public static void main(String... args) {
		// List<String> tempList = Arrays.asList("A", "B", "C", "D");
	}

	public static void traditionalSort(List<String> targetList) {
		Collections.sort(targetList, new Comparator<String>() {
			@Override
			public int compare(String a, String b) {
				return a.compareTo(b);
			}
		});
	}

	public static void lambdaSyntaxSort1(List<String> targetList) {
		Collections.sort(targetList, (String a, String b) -> {
			return b.compareTo(a);
		});
	}

	public static void lambdaSyntaxSort2(List<String> targetList) {
		Collections.sort(targetList, (String a, String b) -> b.compareTo(a));
	}

	public static void lambdaSyntaxSort3(List<String> targetList) {
		Collections.sort(targetList, (a, b) -> b.compareTo(a));
	}

}
