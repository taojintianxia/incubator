package com.github.taojintianxia.incubator.test.multi;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TestClass {

    private static final Random RANDOM = new Random();
    private static List<String> FILTERS = new CopyOnWriteArrayList<>();
    private static ReadWriteLock reentrantLock = new ReentrantReadWriteLock();
    private static Lock readLock = reentrantLock.readLock();
    private static Lock writeLock = reentrantLock.writeLock();

    static {
        for (int i = 0; i < 10; i++) {
            FILTERS.add("" + RANDOM.nextInt(100));
        }
    }

    public void changeFilters() {
        writeLock.lock();
        List<String> FILTERS_COPY = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 10; i++) {
            FILTERS_COPY.add("" + RANDOM.nextInt(100));
        }
        FILTERS = FILTERS_COPY;
        writeLock.unlock();
    }

    public static void main(String... args) throws InterruptedException {

        for (int i = 0; i < FILTERS.size(); i++) {
            System.out.print(FILTERS.get(i) + " _ ");
        }

        System.out.println();

        // for (int i = 0; i < 10; i++) {
        new Thread(new Runnable() {

            @Override
            public void run() {

                // Iterator<String> iterator = FILTERS.iterator();
                // while (iterator.hasNext()) {
                // try {
                // Thread.currentThread().sleep(1000);
                // } catch (InterruptedException e) {
                // e.printStackTrace();
                // }
                // System.out.println(Thread.currentThread().getName() + "_" + " : " +
                // iterator.next());
                //
                // }

                TestClass.readLock.lock();
                for (int i = 0; i < FILTERS.size(); i++) {
                    try {
                        Thread.currentThread().sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "_" + i + " : " + FILTERS.get(i));
                }
                TestClass.readLock.unlock();
            }
        }).start();
        // }

        Thread.sleep(4000);

        // for (int i = 0; i < 1000; i++) {
        new Thread(new Runnable() {

            @Override
            public void run() {
                TestClass testClass = new TestClass();
                testClass.changeFilters();
                for (int i = 0; i < FILTERS.size(); i++) {
                    System.out.print(FILTERS.get(i) + " _ ");
                }
                System.out.println();
            }
        }).start();
        // }

    }

}

