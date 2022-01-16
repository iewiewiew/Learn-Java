package org.example.controller;

import org.example.dao.entity.User;
import org.example.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author weimenghua
 * @time 2023-01-14 09:24
 * @description
 */

@RestController
public class UserController {
    @Resource
    private UserService userService;

    /**
     * http://127.0.0.1:9999/errorUpdate
     * 先增加一条数据 1｜demo｜demo
     */
    @RequestMapping("/errorUpdate")
    public Object first() {
        User user = new User();
        user.setId(1);
        user.setUsername("admin");
        user.setPassword("admin");
        userService.updateUserError(user);
        return "first controller";
    }

    @RequestMapping("/errorUpdate2")
    public Object second() {
        User user = new User();
        user.setId(1);
        user.setUsername("admin");
        user.setPassword("admin");
        userService.updateUserError2(user);
        return "second controller";
    }
}
