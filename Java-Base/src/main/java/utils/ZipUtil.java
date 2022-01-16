package utils;

import java.io.IOException;
import net.lingala.zip4j.ZipFile;

/**
 * 解压Zip文件
 */
public class ZipUtil {
    public static void main(String[] args) throws IOException {
        String filePath = GetPath.getFilePath() + "\\files\\";
        String zipFileFullName = filePath + "\\alipay_record_20211230_140040.zip";
        UnzipFile(zipFileFullName, filePath);
    }


    public static void UnzipFile(String zipFileFullName, String filePath) throws IOException {
        try{
            ZipFile zipFile = new ZipFile(zipFileFullName);
            if (zipFile.isEncrypted()) {
                zipFile.setPassword("200022".toCharArray());
            }
            zipFile.extractAll(filePath);
            String fileName = zipFile.getFileHeaders().get(0).getFileName();
            System.out.println("文件名称：" + fileName);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
