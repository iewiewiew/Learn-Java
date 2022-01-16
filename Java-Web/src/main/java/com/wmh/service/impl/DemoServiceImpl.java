package com.wmh.service.impl;


import com.wmh.dao.DemoMapper;
import com.wmh.domain.Demo;
import com.wmh.service.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author weimenghua
 * @date 2021-11-14 13:28
 */
@Service
public class DemoServiceImpl implements DemoService {

    private final Logger logger = LoggerFactory.getLogger(DemoServiceImpl.class);

    @Autowired
    DemoMapper demoMapper;

    @Override
    public List<Demo> allDemo() {
        return demoMapper.allDemo();
    }

    @Override
    public List<Demo> listByPage(Integer pageNum, Integer pageSize) {
        return demoMapper.listByPage(pageNum, pageSize);
    }

    @Override
    public int tatol() {
        return demoMapper.total();
    }

    @Override
    public Demo findDemoById(Integer id) {
        return demoMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean addDemo(Demo demo) {
        return demoMapper.insertSelective(demo) > 0;
    }

    @Override
    public boolean deleteDemo(Integer id) {
        return demoMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public boolean updateDemo(Demo demo) {
        return demoMapper.updateByPrimaryKey(demo) > 0;
    }
}