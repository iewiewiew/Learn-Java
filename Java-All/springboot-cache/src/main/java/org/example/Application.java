package org.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author weimenghua
 * @time 2023-01-13 12:08
 * @description
 *
 * 参考资料：https://www.iocoder.cn/Spring-Boot/Cache/?github
 */

@SpringBootApplication
@EnableCaching
@MapperScan(basePackages = "org.example.mapper")
public class Application {
}
