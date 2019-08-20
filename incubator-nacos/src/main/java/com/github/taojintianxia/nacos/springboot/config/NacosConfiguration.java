package com.github.taojintianxia.nacos.springboot.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author Nianjun Sun
 * @date 2018/12/18 11:41
 */
@Data
@Configuration
public class NacosConfiguration {

    @Value("${student.name:}")
    private String name;

    @Value("${student.age:}")
    private Integer age;

    @Value("${student.gender:}")
    private String gender;
}
