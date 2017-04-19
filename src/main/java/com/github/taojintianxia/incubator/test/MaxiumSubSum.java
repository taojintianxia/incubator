package com.github.taojintianxia.incubator.test;

import java.util.Random;

/**
 * 
 * 
 * @author Kane.Sun
 * @version Feb 21, 2014 11:54:52 AM
 * 
 */

public class MaxiumSubSum {

    private static final Random random = new Random();
    private static final int arrayLength = 15;

    public static void main(String... args) {
        int[] targetArray = new int[arrayLength];
        int indexFrom = 0;
        int indexTo = 0;
        int tmpTotal = 0;
        boolean isIndexFromChanged = false;
        for (int i = 0; i < arrayLength; i++) {
            int tmpNum = random.nextInt(50);
            if (random.nextInt(3) == 0) {
                targetArray[i] = 0 - tmpNum;
            } else {
                targetArray[i] = tmpNum;
            }
            System.out.print(targetArray[i] + " , ");
        }

        for (int i = 0; i < arrayLength - 1; i++) {
            if (isRestSubSumNotMinus(targetArray, i + 1)) {
                tmpTotal += targetArray[i + 1];
                if (i == (arrayLength - 2)) {
                    if (targetArray[arrayLength - 1] > 0) {
                        tmpTotal += targetArray[arrayLength - 1];
                    }
                }

                if (isIndexFromChanged) {
                    indexFrom = i;
                } else {
                    indexTo++;
                }
            } else {
                indexFrom = i + 1;
                indexTo = i + 1;
                isIndexFromChanged = true;
                continue;
            }
        }

        System.out.println();
        System.out.println("------------------------------------------------");
        System.out.println(tmpTotal);
        System.out.println("from " + indexFrom + " To " + indexTo);
        System.out.println("the section sum is " + testSum(targetArray, indexFrom, indexTo));
    }

    public static boolean isRestSubSumNotMinus(int[] targetArray, int index) {
        long total = 0;
        for (int i = index; i < arrayLength; i++) {
            total += targetArray[i];
        }

        return total > 0;
    }

    public static long testSum(int[] targetArray, int indexFrom, int indexTo) {
        long totalSum = 0;
        for (int i = indexFrom; i <= indexTo; i++) {
            totalSum += targetArray[i];
        }

        return totalSum;
    }
}
