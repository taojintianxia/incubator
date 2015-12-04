import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class AccountRelatedStatistics {

	private static final List<String> keyWordList = Arrays.asList("public", "int", "List<");

	private static final List<String> SQL_START_KEY_WORD_LIST = Arrays.asList("@Insert", "@Select", "@Update");

	private static final String EXCLUDE_SQL_START_KEYWORD = "@Options";

	private static final String METHOD_END_SYMBOL = ");";

	private static final String SQL_END_SYMBOL = ")";

	private static final String ENCODING = "UTF-8";

	private static final File sourceFile = new File("/Users/kane/Desktop/UserMapper.java");

	public static void main(String... args) {
		printAllSQLByType("@Select");
	}

	public static void printAllSQLByType(String keyword) {
		List<String> allSQL = new ArrayList<>();
		List<String> allMethod = new ArrayList<>();

		try {
			BufferedReader bufferedReader = readSourceFile();
			String currentLine = null;
			StringBuilder completeSQL = new StringBuilder();
			StringBuilder completeMethod = new StringBuilder();
			boolean isMethodStart = false;
			while ((currentLine = bufferedReader.readLine()) != null) {

				// 遇到@Option开头的, 直接略过
				if (currentLine.trim().startsWith(EXCLUDE_SQL_START_KEYWORD)) {
					continue;
				}

				if (!currentLine.contains(keyword) && completeSQL.length() == 0) {
					if (StringUtils.isEmpty(currentLine.trim())) {
						continue;
					}

					if (isMethodStart) {
						completeMethod.append(currentLine);
						if (currentLine.trim().endsWith(METHOD_END_SYMBOL)) {
							allMethod.add(currentLine.trim());
							isMethodStart = false;
						}
					}
					
					continue;
				}

				// 当前行包含sql开始的关键字
				if (currentLine.contains(keyword) && completeSQL.length() == 0) {
					isMethodStart = false;
					completeSQL.append(currentLine.trim());
					continue;
				}

				completeSQL.append(currentLine.trim());

				// sql已经结束
				if (currentLine.contains(SQL_END_SYMBOL)) {
					allSQL.add(completeSQL.toString());
					completeSQL = new StringBuilder();
					isMethodStart = true;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("一共有 " + allSQL.size() + " 条sql");
		System.out.println("一共有 " + allMethod.size() + " 个方法");

		for (String sql : allSQL) {
			System.out.println(sql + "\n");
		}
	}

	private static BufferedReader readSourceFile() throws IOException {
		InputStreamReader reader = new InputStreamReader(new FileInputStream(sourceFile), ENCODING);
		BufferedReader bufferedReader = new BufferedReader(reader);
		return bufferedReader;
	}
}
