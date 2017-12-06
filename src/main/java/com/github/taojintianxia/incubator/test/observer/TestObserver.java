package com.github.taojintianxia.incubator.test.observer;

import java.util.Date;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.springframework.stereotype.Component;

@Component
public class TestObserver implements Observer {

    private final static ExecutorService fixedThreadPool = Executors.newFixedThreadPool(20);

    private static TestObserver INSTANCE = new TestObserver();

    public static TestObserver getINSTANCE() {
        return INSTANCE;
    }

    public static void main(String... args) {
        for (int i = 0; i < 20; i++) {
            TestObserver.getINSTANCE().update(null, "aaaa");
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        Task task = new Task();
        System.out.println("args is : " + arg);
        Future<String> future = fixedThreadPool.submit(task);
        System.out.println("future is " + future);
    }


    class Task implements Callable<String> {

        @Override
        public String call() throws Exception {
            System.out.println(Thread.currentThread().getName() + " - is running");
            Thread.sleep(2000 + new Random().nextInt(2000));
            System.out.println(Thread.currentThread().getName() + " is over at " + new Date().toLocaleString());
            return new Random().nextInt(100) + "";
        }

    }

    private void test() {
        System.out.println("running in synchronized function");
        try {
            Thread.sleep(new Random().nextInt(1000) + 2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
