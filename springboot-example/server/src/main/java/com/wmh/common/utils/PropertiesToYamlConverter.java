package com.wmh.common.utils;

import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;
import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author weimenghua
 * @time 2024-12-10 14:30
 * @description Java application.properties 转 application.yml
 */

public class PropertiesToYamlConverter {

    public static void main(String[] args) {
        String propertiesFilePath = "/Users/menghuawei/IdeaProjects/my-project/Learn-Java/springboot-example/server/src/main/resources/application.properties";
        System.out.println(propertiesFilePath);
        String yamlFilePath = "/Users/menghuawei/IdeaProjects/my-project/Learn-Java/springboot-example/server/src/main/resources/application.yml";

        try {
            // 读取 properties 文件
            Properties properties = new Properties();
            try (InputStream input = new FileInputStream(propertiesFilePath)) {
                properties.load(input);
            }

            // 转换为层级结构的 LinkedHashMap，保持顺序
            Map<String, Object> yamlMap = new LinkedHashMap<>();
            for (String key : properties.stringPropertyNames()) {
                String[] parts = key.split("\\.");
                Map<String, Object> currentMap = yamlMap;

                for (int i = 0; i < parts.length - 1; i++) {
                    currentMap = (Map<String, Object>) currentMap.computeIfAbsent(parts[i], k -> new LinkedHashMap<>());
                }
                currentMap.put(parts[parts.length - 1], properties.getProperty(key));
            }

            // 配置 YAML 输出选项
            DumperOptions options = new DumperOptions();
            options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
            Yaml yaml = new Yaml(options);

            // 写入 YAML 文件
            try (Writer writer = new FileWriter(yamlFilePath)) {
                yaml.dump(yamlMap, writer);
            }

            System.out.println("转换完成： " + yamlFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
