package com.example.controller;

import com.example.service.HelloService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "Hello 模块")
@RestController
@Slf4j
@RequestMapping("/hello")
public class HelloController {
    @Autowired
    private HelloService helloService;

    @ApiOperation(value = "Hello")
    @GetMapping("/get/{name}")
    public String sayHello(@PathVariable(required = false) String name) {
        log.info("i'm ready to call someone......");
        return helloService.sayHello(name);
    }
}
