package com.github.taojintianxia.incubator.test.observer;

public class MainTest {

    private TestObservable testObservable = TestObservable.getINSTANCE();

    private TestObserver testObserver = TestObserver.getINSTANCE();

    public static void main(String... args) {
        MainTest MainTest = new MainTest();

        MainTest.testxx();
    }

    public void testxx() {
        long start = System.currentTimeMillis();
        testObservable.addObserver(testObserver);
        for (int i = 0; i < 10; i++)
            testObservable.testOb();

        System.out.println("it takes " + (System.currentTimeMillis() - start) / 1000 + " seconds");
    }

}
