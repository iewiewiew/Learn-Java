package com.example.utils;

import java.nio.charset.StandardCharsets;
import java.util.List;

import cn.hutool.core.io.IoUtil;
import cn.hutool.core.io.resource.ClassPathResource;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONUtil;


public class LocalJsonUtil {
    /**
     * 从指定路径获取JSON并转换为List
     *
     * @param path        json文件路径
     * @param elementType List元素类型
     */
    public static <T> List<T> getListFromJson(String path, Class<T> elementType) {
        ClassPathResource resource = new ClassPathResource(path);
        String jsonStr = IoUtil.read(resource.getStream(), StandardCharsets.UTF_8);
        JSONArray jsonArray = new JSONArray(jsonStr);
        return JSONUtil.toList(jsonArray, elementType);
    }
}