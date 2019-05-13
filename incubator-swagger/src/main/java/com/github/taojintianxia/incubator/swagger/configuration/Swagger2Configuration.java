package com.github.taojintianxia.incubator.swagger.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Nianjun Sun
 * @date 2019-05-13 14:35
 */
@Configuration
@EnableSwagger2
public class Swagger2Configuration {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).enable(true).apiInfo(apiInfo()).useDefaultResponseMessages(false)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.github.taojintianxia.incubator.swagger.controller"))
                .paths(PathSelectors.any()).build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("taojintianxia 的 swagger 接口").description(
                "* 操作为删除，新增，更新的，请求方法为POST，请求参数格式为JSON\r" + "* 查询方法一律为GET，查询单条数据前缀一般为 get，查询多条数据前缀一般为 list\r"
                        + "* 响应格式统一为JSON ").version("1.0.0").build();
    }
}