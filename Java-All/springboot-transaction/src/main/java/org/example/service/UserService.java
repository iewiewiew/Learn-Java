package org.example.service;

import org.example.dao.entity.User;
import org.example.dao.repository.UserMapper;
import org.example.exception.MyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;

/**
 * @author weimenghua
 * @time 2023-01-14 09:23
 * @description
 */

@Service
@Transactional(readOnly = true)
public class UserService {
    @Resource
    private UserMapper userMapper;

    public User getById(int id) {
        return userMapper.selectById(id);
    }

    @Transactional(readOnly = false)
    public void updateUserError(User user) {
        userMapper.updateById(user);
        errMethod();
    }

    //指定异常不回滚
    @Transactional(readOnly = false, noRollbackFor = {MyException.class})
    public void updateUserError2(User user){
        userMapper.updateById(user);
        errMethod2();
    }

    private void errMethod() {
        System.out.println("error");
        throw new RuntimeException("runtime");
    }

    private void errMethod2() {
        System.out.println("error");
        throw new MyException("runtime");
    }

}
