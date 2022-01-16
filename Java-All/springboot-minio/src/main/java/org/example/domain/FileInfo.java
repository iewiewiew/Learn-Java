package org.example.domain;

//import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author weimenghua
 * @time 2022-12-06 08:50
 * @description
 */
//@Data
public class FileInfo {
    private MultipartFile file;

    private String path;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
