package com.wmh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author weimenghua
 * @time 2023-01-08 00:59
 * @description
 */

@SpringBootApplication
@MapperScan(basePackages = {"com.wmh.mapper"})
public class ClickHouseApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClickHouseApplication.class, args);
    }

}
