package org.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author weimenghua
 * @time 2023-01-24 15:35
 * @description
 */

@RestController
public class UserController {
    @RequestMapping("/first")
    public Object first(){
        return "first controller";
    }

    @RequestMapping("/second")
    public Object second(){
        return "second controller";
    }

    @RequestMapping("/doError")
    public Object error(){
        return 1 / 0;
    }

}
