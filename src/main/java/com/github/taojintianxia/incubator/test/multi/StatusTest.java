package com.github.taojintianxia.incubator.test.multi;

public class StatusTest {

    public static void main(String... args) throws InterruptedException {
        new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println("what ?");
                StatusProducer statusProducer = StatusProducer.getInstance();
                statusProducer.putBuildingResult("bbb", "apple");
            }
        }).start();


        new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println("what ?");
                StatusProducer statusProducer = StatusProducer.getInstance();
                statusProducer.putBuildingResult("aaaa", "apple");
            }
        }).start();

        Thread.currentThread().sleep(10000);
    }


}
