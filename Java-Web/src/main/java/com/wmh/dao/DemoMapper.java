package com.wmh.dao;


import com.wmh.domain.Demo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DemoMapper {
    List<Demo> allDemo();

    int deleteByPrimaryKey(Integer id);

    List<Demo> listByPage(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);

    int total();

    int insert(Demo record);

    int insertSelective(Demo record);

    Demo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Demo record);

    int updateByPrimaryKey(Demo record);
}