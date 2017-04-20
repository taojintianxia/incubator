package com.github.taojintianxia.incubator.springboot;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@EnableConfigurationProperties
@ConfigurationProperties
@Component
@Data
public class MavenProperties {

    private String name;

}
