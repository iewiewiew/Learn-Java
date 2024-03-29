package org.example.model;

import java.io.Serializable;

/**
 * @author weimenghua
 * @time 2023-01-13 17:00
 * @description
 */
public class LoginRequest implements Serializable {
    private int code;
    private String body;

    public LoginRequest() {
    }

    public LoginRequest(int code, String body) {
        super();
        this.code = code;
        this.body = body;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
