package com.wmh.controller;

import com.wmh.domain.UserDto;
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

@Api(tags = "Swagger 用户管理模块", description = "我是一个描述", hidden = true)
@RestController
@RequestMapping("/api/user")
public class SwaggerTestUserController {
    /**
     * 查询用户列表，返回一个JSON数组
     */
    @ApiOperation("查询用户列表")
    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public Object getUsers() {
        List<UserDto> list = getData();
        return list;
    }

    /**
     * 查询用户信息，返回一个新建的JSON对象
     */
    @ApiOperation("查询用户信息")
    @GetMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Object getUser(@PathVariable("id") Long id) {

        if (Objects.isNull(id)) {
            return null;
        }

        List<UserDto> list = getData();
        UserDto userDto = getUserDto(id, list);

        return userDto;
    }

    /**
     * 新增用户
     */
    @ApiOperation("新增用户")
    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public Object addUser(@RequestBody UserDto user) {

        List<UserDto> list = getData();
        list.add(user);//模拟向列表中增加数据
        return user;
    }

    /**
     * 编辑用户
     */
    @ApiOperation("编辑用户")
    @PutMapping("/users/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Object editUser(@PathVariable("id") Long id, @RequestBody UserDto user) {
        List<UserDto> list = getData();
        for (UserDto userDto : list) {
            if (id.equals(userDto.getId())) {
                userDto = user;
                break;
            }
        }
        return user;
    }

    /**
     * 删除用户
     */
    @ApiOperation("删除用户")
    @DeleteMapping("/users/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Object deleteUser(@PathVariable("id") Long id) {
        List<UserDto> list = getData();
        UserDto userDto = getUserDto(id, list);
        return userDto;
    }

    /**
     * 模拟数据
     */
    private List<UserDto> getData() {
        List<UserDto> list = new ArrayList<>();

        UserDto userDto = new UserDto();
        userDto.setId(1L);
        userDto.setName("admin");
        userDto.setPwd("admin");
        list.add(userDto);

        userDto = new UserDto();
        userDto.setId(2L);
        userDto.setName("zyx1");
        userDto.setPwd("666");
        list.add(userDto);

        userDto = new UserDto();
        userDto.setId(3L);
        userDto.setName("zyx2");
        userDto.setPwd("777");
        list.add(userDto);

        userDto = new UserDto();
        userDto.setId(4L);
        userDto.setName("zyx3");
        userDto.setPwd("888");
        list.add(userDto);

        return list;
    }

    /**
     * 模拟根据id查询列表中的数据
     *
     * @param id
     * @param list
     * @return
     */
    private UserDto getUserDto(Long id, List<UserDto> list) {
        UserDto UserDto = null;
        for (UserDto user : list) {
            if (id.equals(user.getId())) {
                UserDto = user;
                break;
            }
        }
        return UserDto;
    }
}