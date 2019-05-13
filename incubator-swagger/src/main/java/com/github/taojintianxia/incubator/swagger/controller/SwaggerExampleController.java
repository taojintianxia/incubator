package com.github.taojintianxia.incubator.swagger.controller;

import com.github.taojintianxia.incubator.swagger.vo.in.SwaggerPostVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * swagger 的入口为 localhost:8080/swagger-ui.html
 *
 * @author Nianjun Sun
 * @date 2019-05-13 14:50
 */
@Api(value = "Swagger 的接口")
@RestController
public class SwaggerExampleController {

    @GetMapping("testGetRequest")
    @ApiOperation(value = "测试 GET 请求", httpMethod = "GET")
    @ApiImplicitParams({@ApiImplicitParam(name = "paramA", value = "参数 A"),
            @ApiImplicitParam(name = "paramB", value = "参数 B")})
    public void testGetRequest(@RequestParam("param_a") String paramA, @RequestParam("param_b") String paramB) {
        System.out.println("Param A is " + paramA);
        System.out.println("Param B is " + paramB);
    }

    @PostMapping("testPostRequest")
    @ApiOperation(value = "测试 POST 请求", httpMethod = "POST")
    @ApiImplicitParam(name = "SwaggerPostVO", value = "post 请求对应的参数")
    public void testPostRequest(@RequestBody SwaggerPostVO swaggerPostVO) {
        System.out.println(swaggerPostVO.toString());
    }
}
