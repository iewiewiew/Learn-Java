package com.wmh.common.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author weimenghua
 * @time 2024-12-10 14:12
 * @description
 */
// 定义 BaseEntity，可以为所有实体类提供统一的字段和方法
// 实现 Serializable 接口的作用主要是为了支持对象的序列化和反序列化。serialVersionUID 是一个唯一标识符，用于版本控制。当序列化和反序列化时，JVM 使用这个 ID 来确保序列化对象的版本与反序列化时的版本一致。
@Data
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 18L;

    /**
     * ID
     */
    private Integer id;
    /**
     * 创建人
     */
    private String creater;
    /**
     * 更新人
     */
    private String updater;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
}
