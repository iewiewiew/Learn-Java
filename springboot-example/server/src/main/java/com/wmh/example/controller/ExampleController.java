package com.wmh.example.controller;

import com.wmh.example.dto.ExampleDto;
import com.wmh.example.service.ExampleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author weimenghua
 * @time 2024-12-07 12:52
 * @description
 */
@Api(tags = "Example 模块")
@RestController
@RequestMapping("/example")
public class ExampleController {

    @Autowired
    private ExampleService exampleService;

    @ApiOperation(value = "根据 ID 查询 Example")
    @GetMapping(value = "/{id}")
    public ExampleDto getExampleById(@PathVariable long id) {
        return exampleService.findById(id);
    }

    @ApiOperation(value = "查询 Example 列表")
    @GetMapping(value = "/list")
    public List<ExampleDto> listExamples() {
        return exampleService.findExamlpeList();
    }

    @ApiOperation(value = "分页查询 Example 列表")
    @ResponseBody
    @PostMapping(value = "/listByPage")
    public Map<String, Object> listByPage(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        int offset = (pageNum - 1) * pageSize;

        Integer total = exampleService.tatol();

        List<ExampleDto> data = exampleService.listByPage(offset, pageSize);

        Map<String, Object> res = new HashMap<>();
        res.put("data", data);
        res.put("total", total);
        return res;
    }

    @ApiOperation(value = "新增 Example")
    @PostMapping(value = "/add")
    public void createExample(@RequestBody ExampleDto exampleDto) {
        exampleService.add(exampleDto);
    }

    @ApiOperation(value = "更新 Example")
    @PutMapping(value = "/update")
    public void updateExample(@RequestBody ExampleDto exampleDto) {
        exampleService.update(exampleDto);
    }

    @ApiOperation(value = "删除 Example")
    @DeleteMapping(value = "/{id}")
    public void deleteExample(@PathVariable long id) {
        exampleService.delete(id);
    }
}
