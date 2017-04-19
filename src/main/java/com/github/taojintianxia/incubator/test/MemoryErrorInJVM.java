package com.github.taojintianxia.incubator.test;

import java.util.ArrayList;
import java.util.List;

public class MemoryErrorInJVM {

    private class OOMObject {}

    public static void main(String[] args) {
        MemoryErrorInJVM tester = new MemoryErrorInJVM();
        // tester.testOOMInHeap();
        // tester.testOOMInStack();
        // tester.testStackOverFlow();
        tester.testOOMInPermGen();
    }

    public void testOOMInHeap() {
        List<OOMObject> testList = new ArrayList<>();
        while (true) {
            testList.add(new OOMObject());
        }
    }

    public void testOOMInStack() {
        while (true) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    // Do nothing
                    try {
                        Thread.sleep(5_000_000);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }

    public void testStackOverFlow() {
        testStackOverFlow();
    }

    public void testOOMInPermGen() {
        int i = 0;
        List<String> testList = new ArrayList<>();
        while (true) {
            testList.add(new String(i + "").intern());
        }
    }

}
