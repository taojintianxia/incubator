package com.github.taojintianxia.incubator.test.observer;

import java.util.Observable;

public class TestObservable extends Observable {

    private TestObservable() {}

    private static TestObservable INSTANCE = new TestObservable();

    public static TestObservable getINSTANCE() {
        return INSTANCE;
    }

    public void testOb() {
        this.setChanged();
        this.notifyObservers("1111111");
    }

}
