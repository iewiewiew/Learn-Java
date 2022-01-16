package com.wmh.service;

import com.wmh.domain.Demo2;

import java.util.List;

/**
 * @author weimenghua
 * @time 2022-12-03 17:11
 * @description
 */
public interface DemoService2 {
    int create(String username, String password);

    List<Demo2> getByUserName(String username);

    int deleteByUsername(String username);

    int getAllDemo2();

    int deleteAllDemo2();
}
