package com.wmh.example.service;

import com.wmh.example.dto.ExampleDto;

import java.util.List;

/**
 * @author weimenghua
 * @time 2024-12-09 10:44
 * @description
 */
public interface ExampleService {
    ExampleDto findById(long id);

    List<ExampleDto> findExamlpeList();

    List<ExampleDto> listByPage(Integer pageNum, Integer pageSize);

    int tatol();

    void add(ExampleDto exampleDto);

    void update(ExampleDto exampleDto);

    void delete(long id);
}
