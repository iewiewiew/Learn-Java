package com.example.common;

import java.util.Map;

/**
 * @author weimenghua
 * @time 2024-12-06 15:13
 * @description 处理返回的公共方法 注：待完善
 */
public class CommonResult<T> {
    private int code; // 状态码
    private String message; // 响应消息
    private T data; // 数据

    public CommonResult(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> CommonResult<T> success(Integer code, String message, T data) {
        return new CommonResult<>(code, message, data);
    }

    public static CommonResult<Map<String, Object>> success(Integer code, String message, Map<String, Object> data) {
        return new CommonResult<>(code, message, data);
    }

    public static <T> CommonResult<T> error(Integer code, String message) {
        return new CommonResult<>(code, message, null);
    }

    // Getters 和 Setters
    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }
}
