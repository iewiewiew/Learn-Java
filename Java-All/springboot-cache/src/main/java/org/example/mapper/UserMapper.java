package org.example.mapper;

import org.example.dataobject.UserDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

/**
 * @author weimenghua
 * @time 2023-01-13 11:46
 * @description
 */
@Repository
public interface UserMapper extends BaseMapper<UserDO> {

    @Cacheable(value = "users", key = "#id")
    UserDO selectById(Integer id);

    @CachePut(value = "users", key = "#user.id")
    default UserDO insert0(UserDO user) {
        this.insert(user);
        return user;
    }

}
