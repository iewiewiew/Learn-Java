package org.example.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author weimenghua
 * @time 2022-12-10 14:34
 * @description 测试读取Apollo配置
 * 测试地址：http://127.0.0.1:9999/apollo/test
 * 参考资料：https://www.iocoder.cn/Spring-Boot/config-apollo/?github
 */
@RequestMapping("/apollo")
@RestController
public class ApolloController {

    @Value("${timeout:我是默认值}")
    private String test;

    @GetMapping(value = "/test")
    public String test(){
        System.out.printf(test);
        return test;
    }
}
