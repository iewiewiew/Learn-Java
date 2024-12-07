package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GetPath {

    public static void main(String[] args) throws IOException {
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss" ).format(new Date()));
        System.out.println("路径：" + GetPath.getFilePath());

        String str = GetPath.getFilePath() + "\\utils\\GetPath.java";
        System.out.println("文件名称：" + GetPath.getFileName(str));
    }

    public static String getFilePath() throws IOException {
        File directory = new File("");//设定为当前文件夹
        String curPath = directory.getAbsolutePath() + "\\Java-Base\\src\\main\\java";//获取绝对路径
        return curPath;
    }

    public static String getFileName(String filePath){
        String fileName = filePath.substring(filePath.lastIndexOf("\\") + 1);
        return fileName;
    }
}