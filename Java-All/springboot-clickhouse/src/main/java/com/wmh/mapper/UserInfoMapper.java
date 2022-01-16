package com.wmh.mapper;

import com.wmh.entity.UserInfo;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * @author weimenghua
 * @time 2023-01-08 00:55
 * @description
 */
public interface UserInfoMapper {
    void saveData (UserInfo userInfo);
    UserInfo selectById (@Param("id") Integer id);
    List<UserInfo> selectList ();
}
