package utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class FileUtil {

    public static void main(String[] args) throws Exception{
        ArrayList arrayList = FileUtil.getFilesArray(GetPath.getFilePath());
        System.out.println("获取文件夹下所有文件：" + arrayList);

        String filePath = GetPath.getFilePath() + "\\utils\\FileUtil.java";
        String str = FileUtil.getFileName(filePath);
        System.out.println("获取文件名称：" + str);

        String createPath = GetPath.getFilePath() + "\\tmp";
        FileUtil.createDir(createPath);

        String createFile = GetPath.getFilePath() + "\\tmp\\tmp.txt";
        FileUtil.createFile(createFile);
    }

    /**
     * 获取文件夹下所有文件
     * @param path
     * @return
     */
    public static ArrayList<File> getFilesArray(String path) {
        File file = new File(path);
        File[] files = file.listFiles();
        ArrayList<File> listFile = new ArrayList<File>();
        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                if (files[i].isFile()) {
                    listFile.add(files[i]);
                }
                if (files[i].isDirectory()) {
                    listFile.addAll(getFilesArray(files[i].toString()));
                }
            }
        }
        return listFile;
    }


    /**
     * 获取文件名称
     * @param filePath
     * @return
     */
    public static String getFileName(String filePath){
        File file = new File(filePath);
        if(file.isFile()){
            String fileName = file.getName();
            return fileName;
        }else{
            return filePath;
        }
    }


    /**
     * 创建目录
     * @param filePath
     * @return
     */
    public static String createDir(String filePath){
        File file = new File(filePath);
        if(!file.isDirectory()){
            file.mkdir();
            System.out.println("创建目录：" + filePath);
        }else{
            System.out.println(filePath + " 该目录已存在！");
        }
        return null;
    }


    /**
     * 创建文件
     * @param filePath
     * @return
     * @throws IOException
     */
    public static String createFile(String filePath) throws IOException {
        File file = new File(filePath);
        if (!file.exists()){
            file.createNewFile();
            System.out.println("创建文件：" + filePath);
        }else{
            System.out.println(filePath + " 该文件已存在！");
        }
        return filePath;
    }
}