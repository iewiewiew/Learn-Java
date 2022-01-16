package com.wmh.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "用户登录类", description = "请求类")
public class SwaggerTestDto {
    @ApiModelProperty(value="用户id", example="1",required=true)
    private Long id;

    @ApiModelProperty(value="用户名称", example="zyx",required=true)
    private String name;

    @ApiModelProperty(value="用户密码", example="666",required=true)
    private String pwd;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}