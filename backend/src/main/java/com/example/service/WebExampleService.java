package com.example.service;

import com.example.dto.WebExampleDto;
import java.util.List;
import java.util.Map;

/**
 * Web 接口示例
 * 该接口提供了一系列处理用户信息的方法。
 */
public interface WebExampleService {

    /**
     * 字符串拼接方法
     * @param a 第一个字符串
     * @param b 第二个字符串
     * @return 拼接后的字符串
     */
    String StringMethod(String a, String b);

    /**
     * 处理用户信息的字符串方法
     * @param request 用户信息请求对象
     * @return 处理结果的字符串
     */
    String StringMethodRequest(WebExampleDto request);

    /**
     * DTO 方法，返回用户信息对象
     * @param a 第一个字符串
     * @param b 第二个字符串
     * @return 用户信息对象
     */
    WebExampleDto DtoMethod(String a, String b);

    /**
     * 处理用户信息的 DTO 方法
     * @param request 用户信息请求对象
     * @return 处理后的用户信息对象
     */
    WebExampleDto DtoMethodRequest(WebExampleDto request);

    /**
     * 字符串和用户信息对象结合的方法
     * @param a 字符串
     * @param request 用户信息请求对象
     * @return 用户信息对象
     */
    WebExampleDto DtoStringMethodRequest(String a, WebExampleDto request);

    /**
     * 字符串和用户信息列表结合的方法
     * @param a 字符串
     * @param webExampleDtoList 用户信息对象列表
     * @return 用户信息对象
     */
    WebExampleDto DtoStringMethodListRequest(String a, List<WebExampleDto> webExampleDtoList);

    /**
     * 获取用户列表
     * @param a 第一个字符串
     * @param b 第二个字符串
     * @return 包含用户信息的映射
     */
    Map<String, Object> getUserList(String a, String b);

    /**
     * 列表方法，处理参数并返回用户信息列表
     * @param param 参数映射
     * @return 用户信息对象列表
     */
    List<WebExampleDto> ListMethod(Map<String, Object> param);

    /**
     * 无返回值的方法
     * @param a 第一个字符串
     * @param b 第二个字符串
     */
    void VoidMethod(String a, String b);

    /**
     * 处理用户信息的无返回值方法
     * @param request 用户信息请求对象
     */
    void VoidMethodRequest(WebExampleDto request);

    /**
     * 无参数的无返回值方法
     */
    void VoidMethodNoArgs();

    /**
     * 布尔方法，根据字符串返回布尔值
     * @param a 输入字符串
     * @return 布尔值
     */
    boolean BooleanMethod(String a);

    /**
     * 整数方法，根据字符串返回整数
     * @param a 输入字符串
     * @return 整数值
     */
    int IntMetod(String a);
}