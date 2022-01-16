package com.wmh.service.impl;

import com.wmh.domain.Demo2;
import com.wmh.service.DemoService2;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author weimenghua
 * @time 2022-12-03 17:15
 * @description
 */
@Service
public class DemoServiceImpl2 implements DemoService2 {
    private JdbcTemplate jdbcTemplate;

    DemoServiceImpl2(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int create(String username, String password) {
        return jdbcTemplate.update("insert into demo(username, password) value(?, ?)", username, password);
    }

    @Override
    public List<Demo2> getByUserName(String username) {
        List<Demo2> demo2s = jdbcTemplate.query("select username, password from demo where username = ?", (resultSet, i) -> {
            Demo2 demo2 = new Demo2();
            demo2.setUsername(resultSet.getString("username"));
            demo2.setPassword(resultSet.getString("password"));
            return demo2;
        }, username);
        return demo2s;
    }

    @Override
    public int deleteByUsername(String username) {
        return jdbcTemplate.update("delete from demo where username = ?", username);
    }

    @Override
    public int getAllDemo2() {
        return jdbcTemplate.queryForObject("select count(1) from demo", Integer.class);
    }

    @Override
    public int deleteAllDemo2() {
        return jdbcTemplate.update("delete from demo");
    }
}
