package com.wmh.dto;

/**
 * @author weimenghua
 * @time 2024-11-30 19:03
 * @description
 */
public class ApiMockResponse {
    private int code;
    private String data;

    public ApiMockResponse(int code, String data) {
        this.code = code;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public String getData() {
        return data;
    }
}
