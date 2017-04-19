package com.github.taojintianxia.incubator.test;

public class ReflectionTest {

    public static void main(String... args) {

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
