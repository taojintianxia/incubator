package com.github.taojintianxia.springboot.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.taojintianxia.incubator.springboot.MavenProperties;
import com.github.taojintianxia.incubator.springboot.SpringConfigLoader;
import com.github.taojintianxia.incubator.springboot.ValueProperties;
import com.github.taojintianxia.springboot.SpringTestContext;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)
// @SpringBootTest(classes = SpringTestContext.class)
@ContextConfiguration(classes = SpringTestContext.class)

@Slf4j
public class SpringBootAppTest {

    @Autowired
    private SpringConfigLoader springConfigLoader;

    @Autowired
    private ValueProperties valueProperties;

    @Test
    public void testSpringConfigLoader() {
        MavenProperties mavenProperties = springConfigLoader.getMavenProperties();
        log.info("maven home is : " + mavenProperties.getName());
        log.info("value home is : " + valueProperties.getName());
    }

}
