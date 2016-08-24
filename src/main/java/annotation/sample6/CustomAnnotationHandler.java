package annotation.sample6;

import java.util.Arrays;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class CustomAnnotationHandler implements ApplicationContextAware, InitializingBean {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        final Map<String, Object> myFoos =
            applicationContext.getBeansWithAnnotation(CustomAnnotation.class);

        for (final Object myFoo : myFoos.values()) {
            final Class<? extends Object> fooClass = myFoo.getClass();
            final CustomAnnotation annotation = fooClass.getAnnotation(CustomAnnotation.class);
            logger.info("Found foo class: " + fooClass + ", with tags: "
                + Arrays.toString(annotation.tags()));
        }
    }
}
