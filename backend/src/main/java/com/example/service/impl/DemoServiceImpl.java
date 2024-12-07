package com.example.service.impl;


import com.example.dao.DemoMapper;
import com.example.dto.DemoDto;
import com.example.dto.DemoExportReqVo;
import com.example.service.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
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
    public List<DemoDto> allDemo() {
        return demoMapper.allDemo();
    }

    @Override
    public List<DemoDto> listByPage(Integer pageNum, Integer pageSize) {
        return demoMapper.listByPage(pageNum, pageSize);
    }

    @Override
    public List<DemoExportReqVo> getDemoList(DemoExportReqVo demoExportReqVo) {
        return demoMapper.selectList(demoExportReqVo);
    }

    @Override
    public int total() {
        return demoMapper.total();
    }

    @Override
    public DemoDto findDemoById(Integer id) {
        return demoMapper.selectByPrimaryKey(id);
    }

    @Override
    public String addDemo(DemoDto demoDto) {
        try {
            demoMapper.insertSelective(demoDto);
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
    public int deleteBatch(List<Integer> ids) {
        if (ids == null || ids.isEmpty()) {
            throw new IllegalArgumentException("删除 ID 列表不能为空！");
        }
        return demoMapper.deleteBatchByIds(ids);
    }

    @Override
    public boolean updateDemo(DemoDto demoDto) {
        return demoMapper.updateByPrimaryKey(demoDto) > 0;
    }

}