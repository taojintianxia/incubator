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
            System.out.println("method is : " + method.getName());
            Annotation[] annotaions = method.getAnnotations();
            for (Annotation anno : annotaions) {
                System.out.println(anno);
            }
            MethodLevelAnnotation2 annotation = method.getAnnotation(MethodLevelAnnotation2.class);
            MethodLevelAnnotation annotationzz = method.getAnnotation(MethodLevelAnnotation.class);

            System.out.println(annotationzz);
            if (annotation != null) {
                System.out.println(annotation.toString());
                Method[] methods2 = annotation.getClass().getDeclaredMethods();
                for (Method methodx : methods2) {
                    System.out.println(methodx.getName());
                }
            }
        }

    }

}
