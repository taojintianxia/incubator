package com.github.taojintianxia.nacos.springboot.controller;

import com.github.taojintianxia.nacos.springboot.config.NacosConfiguration;
import com.github.taojintianxia.nacos.springboot.config.NacosDynamicConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * @author Nianjun Sun
 * @date 2019-08-19 12:52
 */
@Controller
@RequestMapping("springboot")
public class ConfigController {

    @Autowired
    private NacosConfiguration nacosConfiguration;

    @Autowired
    private NacosDynamicConfiguration nacosDynamicConfiguration;

    @RequestMapping(value = "/get", method = GET)
    @ResponseBody
    public String get() {
        return nacosConfiguration.toString();
    }

    @RequestMapping(value = "/getDynamic", method = GET)
    @ResponseBody
    public String getDynamic() {
        return nacosDynamicConfiguration.toString();
    }
}
