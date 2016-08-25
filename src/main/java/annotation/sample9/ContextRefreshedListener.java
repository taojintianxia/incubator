package annotation.sample9;

import java.util.Map;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class ContextRefreshedListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        // 根容器为Spring容器
        if (event.getApplicationContext().getParent() == null) {
            Map<String, Object> beans =
                event.getApplicationContext().getBeansWithAnnotation(MethodLevelAnnotation.class);
            System.out.println(beans.size() + "------------------------------");
            for (Object bean : beans.values()) {
                System.out.println(bean == null ? "null" : bean.getClass().getName());
            }
            System.out.println(
                "=====ContextRefreshedEvent=====" + event.getSource().getClass().getName());
        }
    }
}
