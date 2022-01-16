package com.wmh.entity;

import lombok.Data;

/**
 * @author weimenghua
 * @time 2023-01-08 00:53
 * @description
 */

@Data
public class UserInfo {
    private int id;
    private String userName;
    private String passWord;
    private String phone;
    private String createDay;
}
