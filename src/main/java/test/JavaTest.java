package test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public class JavaTest {

    private static Logger logger = Logger.getLogger(JavaTest.class.getSimpleName());
    private static final Integer TOTAL_COUNT = 3;

    // 匹配1-9的数字
    private static final String REGEX = "[1-9]+";

    public static void main(String... args) {

        List<String> testList = Arrays.asList("00001", "201", "zj", "22", "90");
        JavaTest.getTotalNumberSum(testList);
    }

    public static Integer getTotalNumberSum(List<String> targetStrList) {
        int result = 0;
        if (targetStrList == null || targetStrList.isEmpty()) {
            return result;
        }

        // 每一位最大的数都保存在一个map里, key为位数, value为最大值
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int i = 0; i < TOTAL_COUNT; i++) {
            countMap.put(i, 0);
        }

        for (String targetStr : targetStrList) {
            String transferStr = targetStr;
            if (targetStr == null) {
                logger.info("目标字符串为空,跳过");
                continue;
                // 超过三位就切割成为三位
            } else if (targetStr.length() > 3) {
                transferStr = targetStr.substring(targetStr.length() - 3, targetStr.length());
            } else {
                // 不足三位就补齐
                while (transferStr.length() < 3) {
                    transferStr = 0 + transferStr;
                }
            }

            getMaxmiumNum(transferStr, countMap);
        }

        logger.info("最大的三位如下");
        for (int i = 0; i < countMap.size(); i++) {
            logger.info("第" + i + "位最大值为 : " + countMap.get(i));
            result += countMap.get(i);
        }
        logger.info("最终结果为 : " + result);

        return result;
    }

    private static void getMaxmiumNum(String targetStr, Map<Integer, Integer> maxNumMap) {
        char[] charArray = targetStr.toCharArray();
        for (int i = 0; i < targetStr.length(); i++) {
            // 用来判断是数字还是字符串
            if (Pattern.matches(REGEX, charArray[i] + "")) {
                int number = Integer.parseInt(charArray[i] + "");
                if (number > maxNumMap.get(i)) {
                    maxNumMap.remove(i);
                    maxNumMap.put(i, number);
                }
            }
        }
    }
}
