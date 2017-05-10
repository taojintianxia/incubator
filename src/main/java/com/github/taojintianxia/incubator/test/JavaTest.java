package com.github.taojintianxia.incubator.test;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class JavaTest {

    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);

        for (int i = 0; i < 30; i++) {
            scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
                @Override
                public void run() {
                    long start = System.currentTimeMillis();
                    try {
                        Thread.sleep((new Random().nextInt(5) + 1) * 1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " - Executed!");
                    System.out.println("it takes " + (System.currentTimeMillis() - start) / 1000 + " seconds");
                }
            }, 0, 1, TimeUnit.SECONDS);
        }
    }


}
