package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 
 * @author Kane.Sun
 * @version Mar 7, 2014 8:20:51 AM
 * 
 */

public class URLListExtractor {

	public static void main(String... args) throws IOException {
		String readLine = "";
		List<String> expectedPlayList = new ArrayList<>();
		File playList = new File("c:\\list.txt");
		BufferedReader reader = new BufferedReader(new FileReader(playList));
		while ((readLine = reader.readLine()) != null) {
			String str = new String(readLine.substring(0, readLine.indexOf("	")));
			System.out.println(str);
			expectedPlayList.add(str);
		}

		File newList = new File("c:\\export_list.txt");
		newList.createNewFile();
		BufferedWriter writer = new BufferedWriter(new FileWriter(newList));

		int counter = 0;
		for (String str : expectedPlayList) {
			writer.write(str);
			writer.newLine();
			++counter;
			if (counter == 25) {
				writer.newLine();
				writer.newLine();
				counter = 0;
			}
		}
		writer.flush();

	}
}
