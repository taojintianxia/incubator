package com.github.taojintianxia.incubator.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class JVMTest {
    public static void main(String... args) {
        Runtime run = Runtime.getRuntime();
        long max = run.maxMemory();
        long total = run.totalMemory();
        long free = run.freeMemory();
        long usable = max - total + free;

        System.out.println("最大内存 = " + max);
        System.out.println("已分配内存 = " + total);
        System.out.println("已分配内存中的剩余空间 = " + free);
        System.out.println("最大可用内存 = " + usable);

        Map<Integer, List<String>> testMap = new HashMap<>();
        List<String> testList = new ArrayList<>();
        testList.add(new String("A"));
        testList.add(new String("B"));
        testList.add(new String("C"));
        testMap.put(1, testList);


        String newString = testList.get(0);
        testList.remove(0);
        System.out.println("test list size is : " + testList.size());
        System.out.println(newString);

        Properties prop = System.getProperties();
        Set<Object> keySet = prop.keySet();
        for (Object obj : keySet) {
            System.out.println("System Property: {" + obj.toString() + "," + System.getProperty(obj.toString()) + "}");
        }


    }

}
