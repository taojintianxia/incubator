package com.github.taojintianxia.nacos.springboot.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author Nianjun Sun
 * @date 2019-08-20 16:48
 */
@Data
@Configuration
public class NacosDynamicConfiguration {

    @Value("${dynamic.student.name:}")
    private String name;

    @Value("${dynamic.student.age:}")
    private Integer age;

    @Value("${dynamic.student.gender:}")
    private String gender;
}
