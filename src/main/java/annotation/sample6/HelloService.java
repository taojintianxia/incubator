package annotation.sample6;

@CustomAnnotation(cool = false, tags = { "sixfoo" })
public class HelloService {
    public String sayHello() {
        return "Hello world!";
    }
}
