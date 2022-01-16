package com.wmh.controller;

import com.wmh.dto.ApiMockResponse;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author weimenghua
 * @time 2024-11-30 18:41
 * @description 为 https://github.com/PanJiaChen/vue-element-admin.git 前端提供的假接口
 */

@Api(tags = "Login 模块")
@RestController
@RequestMapping("/vue-admin-template")
public class LoginController {

    ApiMockResponse apiMockResponse =  new ApiMockResponse(20000, "20000");

    @PostMapping(value = "/user/login")
    public ResponseEntity<Object> getToken() {
        return ResponseEntity.ok(apiMockResponse);
    }

    @GetMapping(value = "/user/info")
    public ResponseEntity<Object> userInfo() {
        String token = "20000";
        return ResponseEntity.ok(apiMockResponse);
    }

    @PostMapping(value = "/user/logout")
    public ResponseEntity<Object> userLogut() {
        return ResponseEntity.ok(apiMockResponse);
    }
}
