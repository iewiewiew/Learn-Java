package org.example.mapper;

import org.example.dataobject.UserDO;
import org.springframework.stereotype.Repository;

/**
 * @author weimenghua
 * @time 2023-01-13 11:42
 * @description
 */

@Repository
public class UserCacheDao {
    public UserDO get(Integer id) {
        return new UserDO();
    }

    public void put(UserDO user) {

    }
}
