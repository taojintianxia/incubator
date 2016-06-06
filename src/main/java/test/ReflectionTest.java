package test;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

public class ReflectionTest {

	public static void main(String... args) {

		List<String> collumnList = Arrays.asList("account_name", "name", "gender", "home_status");
		DataParty testData = new DataParty();

		testData.setAccountName("accc");
		testData.setName("kane");
		testData.setGender(false);
		testData.setHomeAddress("here");
		testData.setHomeStatus("so goood");

		Field[] fields = testData.getClass().getDeclaredFields();

		for (String str : collumnList) {
			for (Field field : fields) {
				if (recoverFieldName(str).equals(field.getName())) {
					System.out.println("该字段应该显示 : " + field.getName());
				}
			}
		}

	}

	public static String recoverFieldName(String columnName) {
		if (columnName.contains("_")) {
			String tmpColumnName = new String(columnName);

			// 清理字符串中下划线前后缀
			while (tmpColumnName.length() > 0) {
				if (tmpColumnName.endsWith("_")) {
					tmpColumnName = tmpColumnName.substring(0, tmpColumnName.length() - 1);
				} else if (tmpColumnName.startsWith("_")) {
					tmpColumnName = tmpColumnName.substring(1, tmpColumnName.length());
				} else {
					break;
				}
			}

			char[] charArray = tmpColumnName.toCharArray();
			StringBuilder stringBuilder = new StringBuilder();

			// 如果遇到下划线,则将下划线后的字符串转换为大写
			for (int i = 0; i < charArray.length; i++) {
				if (charArray[i] == '_') {
					i = i + 1;
					stringBuilder.append(String.valueOf(charArray[i]).toUpperCase());
				} else {
					stringBuilder.append(charArray[i]);
				}
			}

			return stringBuilder.toString();
		} else {
			return columnName;
		}
	}
}
