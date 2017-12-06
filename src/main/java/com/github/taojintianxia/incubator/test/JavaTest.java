package com.github.taojintianxia.incubator.test;

public class JavaTest {

    public static void main(String... args) {
        JavaTest aJavaTest = new JavaTest();
        JavaTest bJavaTest = new JavaTest();

        aJavaTest.testSynch("apple");
        aJavaTest.testSynch("banana");

    }

    public void testSynch(String name) {
        synchronized (name) {
            System.out.println("locking " + name);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
