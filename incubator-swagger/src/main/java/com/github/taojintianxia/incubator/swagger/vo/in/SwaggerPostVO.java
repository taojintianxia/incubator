package com.github.taojintianxia.incubator.swagger.vo.in;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Nianjun Sun
 * @date 2019-05-13 14:59
 */
@Data
@ApiModel
public class SwaggerPostVO {

    @ApiModelProperty(value = "用户姓名")
    private String name;

    @ApiModelProperty(value = "用户年龄")
    private Integer age;

    @ApiModelProperty(value = "用户性别")
    private String gender;
}
