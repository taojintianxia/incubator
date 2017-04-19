package com.github.taojintianxia.incubator.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Getter;

@Component
@Getter
public class SpringConfigLoader {

    @Autowired
    private MavenProperties mavenProperties;

}
