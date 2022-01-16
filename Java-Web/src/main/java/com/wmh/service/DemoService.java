package com.wmh.service;

import com.wmh.domain.Demo;
import java.util.List;

/**
 * @author weimenghua
 * @date 2021-11-14 13:26
 */
public interface DemoService {

    /**
     * 列表查询
     */
    List<Demo> allDemo();

    /**
     * 分页查询
     */
    List<Demo> listByPage(Integer pageNum, Integer pageSize);

    int tatol();
    /**
     * 根据条件查找
     */
    Demo findDemoById(Integer id);

    /**
     * 新增
     */
    boolean addDemo(Demo demo);

    /**
     * 删除
     */
    boolean deleteDemo(Integer id);

    /**
     * 更新
     */
    boolean updateDemo(Demo demo);
}
