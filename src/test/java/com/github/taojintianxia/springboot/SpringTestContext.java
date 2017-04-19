package com.github.taojintianxia.springboot;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = {"application.properties"})
@ComponentScan(basePackages = {"com.github.taojintianxia.incubator"})
public class SpringTestContext {

}
