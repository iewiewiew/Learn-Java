package org.example.util;

import com.alibaba.fastjson.JSON;

/**
 * @author weimenghua
 * @time 2023-01-11 10:22
 * @description
 */
public class JSONUtil {
    public static  <T> T parseObject(String text, Class<T> clazz) {
        return JSON.parseObject(text, clazz);
    }

    public static String toJSONString(Object javaObject) {
        return JSON.toJSONString(javaObject);
    }

    public static byte[] toJSONBytes(Object javaObject) {
        return JSON.toJSONBytes(javaObject);
    }
}
