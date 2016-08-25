package annotation.sample7;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import annotation.sample7.testclass.NormalClass;
import annotation.sample7.testclass.SpringClass;

@Configuration
@ComponentScan(basePackages = "annotation")
public class Demo {

    public static void main(String... args) {
        // AnnotationConfigApplicationContext context = new
        // AnnotationConfigApplicationContext();
        // context.register(Demo.class);
        // context.refresh();

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");

        NormalClass normalClass = null;
        SpringClass springClass = null;

        try {
            context.getBean(NormalClass.class);
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            context.getBean(SpringClass.class);
        } catch (Exception e) {
            System.out.println(e);
        }

        if (normalClass != null)
            normalClass.printMsg();

        if (springClass != null)
            springClass.printMsg();

        // ApplicationContext context = new
        // ClassPathXmlApplicationContext("spring-config.xml");
        // HelloService helloService = context.getBean(HelloService.class);
        // System.out.println(helloService.sayHello());
    }

}
