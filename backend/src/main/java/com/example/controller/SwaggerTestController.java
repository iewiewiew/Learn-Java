package com.example.controller;

import com.example.dto.SwaggerTestDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 测试Swagger
 */

@Api(tags = "Swagger 测试管理模块", description = "我是一个描述", hidden = true)
@RestController
@RequestMapping("/api/swaggerTest")
public class SwaggerTestController {
    /**
     * 查询 SwaggerTest 列表，返回一个 JSON 数组
     */
    @ApiOperation("查询 SwaggerTest 列表")
    @GetMapping("/tests")
    @ResponseStatus(HttpStatus.OK)
    public Object getSwaggerTests() {
        List<SwaggerTestDto> list = getData();
        return list;
    }

    /**
     * 查询 SwaggerTest 信息，返回一个新建的 JSON 对象
     */
    @ApiOperation("查询 SwaggerTest 信息")
    @GetMapping("/tests/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Object getSwaggerTest(@PathVariable("id") Long id) {

        if (Objects.isNull(id)) {
            return null;
        }

        List<SwaggerTestDto> list = getData();
        SwaggerTestDto swaggerTestDto = getSwaggerTestDto(id, list);

        return swaggerTestDto;
    }

    /**
     * 新增 SwaggerTest
     */
    @ApiOperation("新增 SwaggerTest")
    @PostMapping("/tests")
    @ResponseStatus(HttpStatus.CREATED)
    public Object addSwaggerTest(@RequestBody SwaggerTestDto swaggerTest) {

        List<SwaggerTestDto> list = getData();
        list.add(swaggerTest); // 模拟向列表中增加数据
        return swaggerTest;
    }

    /**
     * 编辑 SwaggerTest
     */
    @ApiOperation("编辑 SwaggerTest")
    @PutMapping("/tests/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Object editSwaggerTest(@PathVariable("id") Long id, @RequestBody SwaggerTestDto swaggerTest) {
        List<SwaggerTestDto> list = getData();
        for (SwaggerTestDto swaggerTestDto : list) {
            if (id.equals(swaggerTestDto.getId())) {
                swaggerTestDto = swaggerTest;
                break;
            }
        }
        return swaggerTest;
    }

    /**
     * 删除 SwaggerTest
     */
    @ApiOperation("删除 SwaggerTest")
    @DeleteMapping("/tests/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Object deleteSwaggerTest(@PathVariable("id") Long id) {
        List<SwaggerTestDto> list = getData();
        SwaggerTestDto swaggerTestDto = getSwaggerTestDto(id, list);
        return swaggerTestDto;
    }

    /**
     * 模拟数据
     */
    private List<SwaggerTestDto> getData() {
        List<SwaggerTestDto> list = new ArrayList<>();

        SwaggerTestDto swaggerTestDto = new SwaggerTestDto();
        swaggerTestDto.setId(1L);
        swaggerTestDto.setName("admin");
        swaggerTestDto.setPwd("admin");
        list.add(swaggerTestDto);

        swaggerTestDto = new SwaggerTestDto();
        swaggerTestDto.setId(2L);
        swaggerTestDto.setName("zyx1");
        swaggerTestDto.setPwd("666");
        list.add(swaggerTestDto);

        swaggerTestDto = new SwaggerTestDto();
        swaggerTestDto.setId(3L);
        swaggerTestDto.setName("zyx2");
        swaggerTestDto.setPwd("777");
        list.add(swaggerTestDto);

        swaggerTestDto = new SwaggerTestDto();
        swaggerTestDto.setId(4L);
        swaggerTestDto.setName("zyx3");
        swaggerTestDto.setPwd("888");
        list.add(swaggerTestDto);

        return list;
    }

    /**
     * 模拟根据 ID 查询列表中的数据
     *
     * @param id
     * @param list
     * @return
     */
    private SwaggerTestDto getSwaggerTestDto(Long id, List<SwaggerTestDto> list) {
        SwaggerTestDto swaggerTestDto = null;
        for (SwaggerTestDto swaggerTest : list) {
            if (id.equals(swaggerTest.getId())) {
                swaggerTestDto = swaggerTest;
                break;
            }
        }
        return swaggerTestDto;
    }
}