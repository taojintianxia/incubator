package annotation.sample9;

import org.springframework.stereotype.Component;

@Component
public class HelloService {

    @MethodLevelAnnotation2
    public void sayHello() {
        System.out.println("demo 9 is saying hello");
    }

}
