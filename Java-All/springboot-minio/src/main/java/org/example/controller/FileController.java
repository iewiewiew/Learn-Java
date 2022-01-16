package org.example.controller;

import io.minio.*;
import io.swagger.annotations.Api;
import org.example.domain.FileInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author weimenghua
 * @time 2022-12-05 21:55
 * @description Minio
 * 参考资料：https://www.iocoder.cn/Spring-Boot/MinIO/?github
 */
@Api(tags = "文件模块")
@RestController
@RequestMapping("/file")
public class FileController {
    private FileInfo fileInfo;
    @Resource
    private MinioClient minioClient;
    private String endpoint = "http:///127.0.0.1:9000";
    private String bucket = "demo";


    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String uplaod(@RequestParam("file") MultipartFile file) throws Exception{
        String path = UUID.randomUUID().toString();
        minioClient.putObject(PutObjectArgs.builder()
                .bucket(bucket)
                .object(fileInfo.getPath())
                .stream(file.getInputStream(), file.getSize(), - 1)
                .contentType(file.getContentType())
                .build());
        return String.format("%s%s%s", endpoint, bucket, path);
    }

}
