package com.wmh.controller;

import com.wmh.entity.UserInfo;
import com.wmh.service.UserInfoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.List;

/**
 * @author weimenghua
 * @time 2023-01-08 00:58
 * @description
 */

@RestController
public class UserInfoController {
    @Resource
    private UserInfoService userInfoService ;

    //http://127.0.0.1:9999/saveData
    @GetMapping("/saveData")
    public String saveData (){
        UserInfo userInfo = new UserInfo () ;
        userInfo.setId(4);
        userInfo.setUserName("demo");
        userInfo.setPassWord("123456");
        userInfo.setPhone("18222050001");
        userInfo.setCreateDay("2023-01-08");
        userInfoService.saveData(userInfo);
        return "success";
    }

    //http://127.0.0.1:9999/getById?id=1
    @GetMapping("/getById")
    public UserInfo getById (int id) {
        return userInfoService.selectById(id) ;
    }

    //http://127.0.0.1:9999/getList
    @GetMapping("/getList")
    public List<UserInfo> getList () {
        return userInfoService.selectList() ;
    }
}
