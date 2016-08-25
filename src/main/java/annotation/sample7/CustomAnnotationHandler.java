package annotation.sample7;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import annotation.sample7.util.AnnotationUtil;

public class CustomAnnotationHandler implements ApplicationContextAware, InitializingBean {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("program is running here");
        List<Class> annotations = AnnotationUtil.getAnnotations();

        for (Class clazz : annotations) {
            Map<String, Object> beansWithAnnotation =
                applicationContext.getBeansWithAnnotation(clazz);
            handleCustomizeAnnotation(beansWithAnnotation, clazz);
        }
    }

    // 这里可以处理包含指定annotation的类
    private void handleCustomizeAnnotation(final Map<String, Object> beansWithAnnotation,
        Class clazz) {
        if (beansWithAnnotation == null || beansWithAnnotation.isEmpty()) {
            return;
        }

        for (Object bean : beansWithAnnotation.values()) {
            Class<? extends Object> targetClass = bean.getClass();
            logger.info("found class : " + targetClass);
        }

    }
}
