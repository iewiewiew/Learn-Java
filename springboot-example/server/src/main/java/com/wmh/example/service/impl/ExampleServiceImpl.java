package com.wmh.example.service.impl;

import com.wmh.example.dto.ExampleDto;
import com.wmh.example.mapper.ExampleMapper;
import com.wmh.example.service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * @author weimenghua
 * @time 2024-12-09 11:04
 * @description
 */
@Service
public class ExampleServiceImpl implements ExampleService {

    @Autowired
    private ExampleMapper exampleMapper;

    @Override
    public ExampleDto findById(long id) {
        return exampleMapper.getById(id);
    }

    @Override
    public List<ExampleDto> findExamlpeList() {
        return exampleMapper.getAll();
    }

    @Override
    public List<ExampleDto> listByPage(Integer pageNum, Integer pageSize) {
        return exampleMapper.listByPage(pageNum, pageSize);
    }

    @Override
    public int tatol() {
        return exampleMapper.total();
    }

    @Override
    public void add(ExampleDto exampleDto) {
        exampleMapper.insert(exampleDto);
    }

    @Override
    public void update(ExampleDto exampleDto) {
        exampleMapper.update(exampleDto);
    }

    @Override
    public void delete(long id) {
        exampleMapper.delete(id);
    }
}
