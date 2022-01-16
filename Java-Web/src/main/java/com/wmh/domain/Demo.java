package com.wmh.domain;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@ApiModel(value = "Demo类", description = "请求类")
public class Demo {

    @NotNull(message = "用户id不能为空")
    private Integer id;

    @NotNull(message = "用户账号不能为空")
    @Size(min = 1, max = 10, message = "账号长度必须是1-10个字符")
    private String username;

    @NotNull(message = "用户密码不能为空")
    @Size(min = 1, max = 10, message = "密码长度必须是1-10个字符")
    private String password;

    private String creater;

    private String updater;
    private Date createTime;
    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

}