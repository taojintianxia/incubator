package com.github.taojintianxia.incubator.springboot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class ValueProperties {

    @Value("${name}")
    private String name;

}
