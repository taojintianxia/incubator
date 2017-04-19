package com.github.taojintianxia.incubator.test;

public class Base {
    private String name = "hello";

    public Base() {
        // System.out.println(this);
        // 关键是要认识到调用callName方法的是sub类型的对象
        callName();
    }

    public void callName() {
        System.out.println(name);
    }

    public static void main(String[] args) {
        new Sub();
    }
}


class Sub extends Base {
    private String name = "world";

    @Override
    public void callName() {
        System.out.println(name);
    }
}
