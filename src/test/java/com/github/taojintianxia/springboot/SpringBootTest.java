package com.github.taojintianxia.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.taojintianxia.incubator.springboot.SpringTestService;

@RunWith(SpringJUnit4ClassRunner.class)
@ComponentScan(basePackages = {"springboot"})
public class SpringBootTest {

    @Autowired
    private SpringTestService springTestService;

    @Test
    public void testInvokeService() {
        springTestService.invokeService();
    }

}
