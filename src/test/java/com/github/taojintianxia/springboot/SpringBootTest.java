package com.github.taojintianxia.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import springboot.SpringTestService;

@RunWith(SpringJUnit4ClassRunner.class)
public class SpringBootTest {

    @Autowired
    private SpringTestService springTestService;

    @Test
    public void testInvokeService() {
        springTestService.invokeService();
    }

}
