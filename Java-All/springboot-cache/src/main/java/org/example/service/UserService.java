package org.example.service;

import org.example.dataobject.UserDO;
import org.example.mapper.UserCacheDao;
import org.example.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author weimenghua
 * @time 2023-01-13 11:56
 * @description
 */
public class UserService {

    @Autowired
    private UserCacheDao userCacheDao;

    @Autowired
    private UserMapper userMapper;

    public UserDO getUser(Integer id) {
        // 从 Cache 中，查询用户信息
        UserDO user = userCacheDao.get(id);
        if (user != null) {
            return user;
        }

        // 如果 Cache 查询不到，从 DB 中读取
        user = userMapper.selectById(id);
        if (user != null) { // 非空，则缓存到 Cache 中
            userCacheDao.put(user);
        }

        // 返回结果
        return user;
    }

    public UserDO getUser2(Integer id) {
        return userMapper.selectById(id);
    }
}
