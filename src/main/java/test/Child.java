package test;

public class Child extends Parent {

    @Override
    public void say() {
        System.out.println("child say");
    }

    public static void main(String... args) {

        Child child = new Child();
        child.action();
    }
}
