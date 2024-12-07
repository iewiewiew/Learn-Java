package com.wmh.example.dto;

import com.wmh.common.entity.BaseEntity;
import lombok.Data;

/**
 * @author weimenghua
 * @time 2024-12-07 12:24
 * @description 实体类
 */

// @Data 注解是一个组合注解，包含了 @Getter、@Setter、@ToString、@EqualsAndHashCode 和 @RequiredArgsConstructor，用于快速创建数据类。
@Data
public class ExampleDto extends BaseEntity {
    /**
     * 用户名称
     */
    private String username;
    /**
     * 用户年龄
     */
    private String age;
    /**
     * 备注
     */
    private String mark;
}
