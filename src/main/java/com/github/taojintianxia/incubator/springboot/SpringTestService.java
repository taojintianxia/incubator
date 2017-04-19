package com.github.taojintianxia.incubator.springboot;

import org.springframework.stereotype.Component;

@Component
public class SpringTestService {

    public void invokeService() {
        System.out.println("Service is invoking");
    }

}
