package com.github.taojintianxia.incubator.test.multi;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class TestCopyOnWriteArrayList {

    public static List<String> testList = new CopyOnWriteArrayList<>();

    public static void main(String... args) {
        for (int i = 0; i < 10; i++) {
            testList.add(i + "");
        }

        new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < testList.size(); i++) {
                    System.out.print(i + "  ");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println();
            }
        }).start();


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        testList.add("xxxx");
        System.out.println("xxx is added");

    }

}
