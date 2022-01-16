package com.wmh.service;

import com.wmh.entity.UserInfo;
import com.wmh.mapper.UserInfoMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

/**
 * @author weimenghua
 * @time 2023-01-08 00:56
 * @description
 */

@Service
public class UserInfoService {
    @Resource
    private UserInfoMapper userInfoMapper ;

    public void saveData(UserInfo userInfo) {
        userInfoMapper.saveData(userInfo);
    }

    public UserInfo selectById(Integer id) {
        return userInfoMapper.selectById(id);
    }

    public List<UserInfo> selectList() {
        return userInfoMapper.selectList();
    }
}
