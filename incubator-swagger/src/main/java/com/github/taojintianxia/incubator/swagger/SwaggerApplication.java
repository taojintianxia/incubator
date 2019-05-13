package com.github.taojintianxia.incubator.swagger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Nianjun Sun
 * @date 2019-05-13 11:56
 */
@SpringBootApplication(scanBasePackages = "com.github.taojintianxia.incubator.swagger")
public class SwaggerApplication  {
    public static void main(String... args) {
        SpringApplication.run(SwaggerApplication.class, args);
    }
}
