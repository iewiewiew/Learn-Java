package com.wmh.service.impl;


import cn.hutool.poi.excel.ExcelReader;
import com.wmh.dao.DemoMapper;
import com.wmh.domain.Demo;
import com.wmh.domain.DemoExportReqVo;
import com.wmh.service.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.Collections;
import java.util.DuplicateFormatFlagsException;
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
    public List<DemoExportReqVo> getDemoList(DemoExportReqVo demoExportReqVo) {
        return demoMapper.selectList(demoExportReqVo);
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
    public String addDemo(Demo demo) {
        try {
            demoMapper.insertSelective(demo);
            return "新增成功";
        } catch (DuplicateKeyException e) {
            System.out.println("ID 重复");
            e.printStackTrace();
            return "新增失败，ID 重复";
        } catch (Exception e) {
            e.printStackTrace();
            return "新增失败";
        }
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