package annotation.sample5;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

@Configuration
public class BeanPostProcessorTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext =
            new AnnotationConfigApplicationContext(BeanPostProcessorTest.class);
        PrintSomething printSomething =
            annotationConfigApplicationContext.getBean(PrintSomething.class);
        printSomething.print();
    }

    public interface PrintSomething {
        void print();
    }

    @Service
    public static class PrintHello implements PrintSomething {

        @Override
        public void print() {
            System.out.println("hello");
        }
    }

    @Service
    public static class BeanPostProcessorService implements BeanPostProcessor {

        @Override
        public Object postProcessBeforeInitialization(Object bean,
            String beanName) throws BeansException {
            System.out.println(bean);
            return bean;
        }

        @Override
        public Object postProcessAfterInitialization(Object bean,
            String beanName) throws BeansException {
            System.out.println(bean);
            return bean;
        }
    }
}
