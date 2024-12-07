package com.example.dto;

import com.alibaba.excel.annotation.ExcelProperty;

import java.util.Date;

/**
 * @author weimenghua
 * @time 2024-11-30 20:18
 * @description
 */
public class DemoExportReqVo {
    @ExcelProperty("ID")
    private Integer id;

    @ExcelProperty("用户名")
    private String username;

    @ExcelProperty("密码")
    private String password;

    @ExcelProperty("创建人")
    private String creater;

    @ExcelProperty("更新人")
    private String updater;

    @ExcelProperty("创建时间")
    private Date createTime;

    @ExcelProperty("更新时间")
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
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
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

    public DemoExportReqVo(Integer id, String username, String password, String creater, String updater, Date createTime, Date updateTime) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.creater = creater;
        this.updater = updater;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

}
