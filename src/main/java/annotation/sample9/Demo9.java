package annotation.sample9;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import org.springframework.context.annotation.Configuration;

@Configuration
public class Demo9 {

    public static void main(String... args) {
        Class clazz = HelloService.class;
        Method[] methods = clazz.getDeclaredMethods();
        if (methods.length == 0) {
            System.out.println("没方法 ? ");
            return;
        }

        for (Method method : methods) {
            Annotation annotation = method.getAnnotation(MethodLevelAnnotation2.class);
            if (annotation != null)
                System.out.println(annotation.toString());
        }

    }

}
