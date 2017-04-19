package test.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;


public class TestClass {

    public static void main(String... args) {
        CommonInterface classA = new ClassA();
        CommonInterface classB = new ClassB();

        Method[] classAMethods = classA.getClass().getDeclaredMethods();
        Method[] classBMethods = classB.getClass().getDeclaredMethods();

        Field[] fields = classA.getClass().getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getType().getName());
        }
    }

}
