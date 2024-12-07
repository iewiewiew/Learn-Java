package com.example.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@ApiModel(value = "Demo类", description = "请求类")
public class DemoDto implements Serializable {
    // 实现 Serializable 接口的作用主要是为了支持对象的序列化和反序列化。serialVersionUID 是一个唯一标识符，用于版本控制。当序列化和反序列化时，JVM 使用这个 ID 来确保序列化对象的版本与反序列化时的版本一致。
    private static final long serialVersionUID = 18L; // 唯一标识符

    /**
    @NotNull：检查字段不能为 null。对于 Integer 类型的字段，需要使用 @NotNull 注解来校验它是否为 null。
    @NotEmpty：检查字段不能为 null 且不能为空字符串（""）。
    @NotBlank：校验字段不能为 null 且只能包含非空白字符（即不能是空字符串也不能是仅包含空格的字符串）。
    */
    @NotNull(message = "用户 ID 不能为空")
    private Integer id;

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    private List<Integer> ids;

    //    @NotEmpty(message = "用户账号不能为空")
//    @Size(min = 1, max = 10, message = "账号长度必须是1-10个字符")
    private String username;

//    @NotBlank(message = "名称不能为空且不能全是空格")
//    @Size(min = 1, max = 10, message = "密码长度必须是1-10个字符")
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

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
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