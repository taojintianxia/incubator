package annotation.sample8;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "annotation.sample8" + "")
public class Demo8 {

    public static void main(String... args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext =
            new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.register(Demo8.class);
        annotationConfigApplicationContext.refresh();
        HelloService helloService = annotationConfigApplicationContext.getBean(HelloService.class);

        System.out.println(helloService.sayHello());

        // ApplicationContext context = new
        // ClassPathXmlApplicationContext("spring-config.xml");
        // HelloService helloService = context.getBean(HelloService.class);
        // System.out.println(helloService.sayHello());
    }

}
