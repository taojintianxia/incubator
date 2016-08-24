package annotation.sample4;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Demo4 {

    public static void main(String... args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext =
            new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.refresh();

        TagedClass injectClass =
            annotationConfigApplicationContext.getBean(TagedClass.class);
        injectClass.printMsg();
    }

}
