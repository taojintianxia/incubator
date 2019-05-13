package com.github.taojintianxia.incubator.swagger.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Nianjun Sun
 * @date 2019-05-13 14:50
 */

@Api(value = "Swagger 的接口")
@RestController
public class SwaggerExampleController {

    @GetMapping
    @ApiOperation(value = "测试 Get 请求", httpMethod = "GET")
    @ApiImplicitParams({@ApiImplicitParam(name = "paramA", value = "参数 A"),
            @ApiImplicitParam(name = "paramB", value = "参数 B")})
    public void testGetRequest(@RequestParam("param_a") String paramA, @RequestParam("param_b") String paramB) {
        System.out.println("Param A is " + paramA);
        System.out.println("Param B is " + paramB);
    }

}
