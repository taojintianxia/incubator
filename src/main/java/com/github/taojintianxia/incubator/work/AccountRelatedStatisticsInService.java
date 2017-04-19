package com.github.taojintianxia.incubator.work;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AccountRelatedStatisticsInService {

    private static final File sourceFile = new File(
            "/Users/kane/Work/workspace/core_money_record_fourth1106/yooli-core/src/main/java/com/fuscent/core/service/impl");
    private static final String ENCODING = "UTF-8";
    private static final String MAPPER_KEYWORD = "userMapper.";
    private static final List<String> METHOD_NAMES = Arrays.asList("getAllUserCashList", "getUserByCashDesc",
            "getUserCashCheckResult", "changeCash", "frozeUserCash", "subtractUserFrozenCash", "frozeUserCashWithDraw",
            "updateUser", "updateUserCashByUserId", "updateCashByUserId", "subtractCashByUserId",
            "updateFreeWithdrawQuotaIncrementByUserId", "updateFreeWithdrawQuotaByUserId", "updateRunUpAccountByUserId",
            "updateUserRunUpAccount", "updateUserFreeWithdrawQuota", "changeAppointmentFrozenCash");

    public static void main(String... args) {
        List<File> files = getAllServiceFile();
        Map<String, Set<String>> resultMap = new HashMap<>();
        for (File file : files) {
            try {
                resultMap = getTheInvokedMethodAndFilePair(file);
                for (Map.Entry<String, Set<String>> map : resultMap.entrySet()) {
                    System.out.println(map.getKey() + " : ");
                    for (String methodName : map.getValue()) {
                        System.out.println("    " + methodName);
                    }
                    System.out.println();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static List<File> getAllServiceFile() {
        List<File> serviceFileList = new ArrayList<>();
        File[] files = sourceFile.listFiles();
        for (File file : files) {
            if (file.isFile() && file.getName().endsWith(".java")) {
                serviceFileList.add(file);
                // System.out.println(file.getName());
            }
        }

        return serviceFileList;
    }

    private static Map<String, Set<String>> getTheInvokedMethodAndFilePair(File file) throws IOException {
        Map<String, Set<String>> resultMap = new HashMap<>();
        Set<String> invokedMethodList = new HashSet<>();

        InputStreamReader reader = new InputStreamReader(new FileInputStream(file), ENCODING);
        BufferedReader bufferedReader = new BufferedReader(reader);
        String currentLine = null;
        while ((currentLine = bufferedReader.readLine()) != null) {
            if (currentLine.contains(MAPPER_KEYWORD)) {
                for (String method : METHOD_NAMES) {
                    if (currentLine.contains(MAPPER_KEYWORD + method)) {
                        invokedMethodList.add(MAPPER_KEYWORD + method);
                    }
                }
            }
        }

        if (!invokedMethodList.isEmpty()) {
            resultMap.put(file.getName(), invokedMethodList);
        }

        return resultMap;
    }
}
