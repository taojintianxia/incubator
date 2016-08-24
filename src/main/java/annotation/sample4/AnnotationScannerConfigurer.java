package annotation.sample4;

import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy(true)
public class AnnotationScannerConfigurer
    implements BeanDefinitionRegistryPostProcessor {

    // ArrayList<String> cache = RemoteCache.getCache();

    @Override
    public void postProcessBeanDefinitionRegistry(
        BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {
    }

    @Override
    public void postProcessBeanFactory(
        ConfigurableListableBeanFactory postProcessBeanFactory)
        throws BeansException {
        Map<String, Object> map =
            postProcessBeanFactory.getBeansWithAnnotation(CustomizeTag.class);
        for (String key : map.keySet()) {
            System.out.println("beanName= " + key);
        }
    }
}
