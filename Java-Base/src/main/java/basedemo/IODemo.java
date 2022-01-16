package basedemo;


import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import utils.GetPath;

/**
 * @author weimenghua
 * @date 2021-11-17 22:08
 */
public class IODemo {
    public static void main(String[] args) throws IOException {
        String filePath = GetPath.getFilePath() + "\\files\\demo.txt";
        File file = new File(filePath);

        write(file);
        System.out.println("读取文件1：" + read(file));

        write2(file);
        System.out.println("读取文件2：" + read2(file));
    }


    public static void write(File file) throws IOException {
        OutputStream os = new FileOutputStream(file, true); //ture：追加写入(默认为true), false：覆盖写入
        //要写入的字符串
        String string = "1、好好学习，天天向上";
        String str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

        //写入文件
        os.write(string.getBytes());
        os.write(str.getBytes());   //写入当前时间
        os.write("\n".getBytes());  //写入换行

        //关闭流
        os.close();
    }


    public static void write2(File file) throws IOException {
        //缓冲字节流，提高了效率
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file, true)); //ture：追加写入(默认为true), false：覆盖写入
        //要写入的字符串
        String string = "2、好好学习，天天向上。";
        //写入文件
        bos.write(string.getBytes());
        //关闭流
        bos.close();
    }


    public static String read(File file) throws IOException {
        InputStream in = new FileInputStream(file);

        //一次性取多少个字节
        byte[] bytes = new byte[1024];
        //用来接收读取的字节数组
        StringBuilder sb = new StringBuilder();
        //读取到的字节数组长度，为-1时表示没有数据
        int length = 0;
        //循环取数据
        while ((length = in.read(bytes)) != -1) {
            //将读取的内容转换成字符串
            sb.append(new String(bytes, 0, length));
        }
        //关闭流
        in.close();
        return sb.toString();
    }


    public static String read2(File file) throws IOException {
        BufferedInputStream fis = new BufferedInputStream(new FileInputStream(file));

        //一次性取多少个字节
        byte[] bytes = new byte[1024];
        //用来接收读取的字节数组
        StringBuilder sb = new StringBuilder();
        //读取到的字节数组长度，为-1时表示没有数据
        int length = 0;
        //循环取数据
        while ((length = fis.read(bytes)) != -1) {
            //将读取的内容转换成字符串
            sb.append(new String(bytes, 0, length));
        }
        //关闭流
        fis.close();
        return sb.toString();
    }
}
