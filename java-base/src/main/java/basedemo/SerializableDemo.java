package basedemo;

import basedemo.dto.People;
import utils.GetPath;
import java.io.*;

/**
 * @author weimenghua
 * @time 2022-02-23 15:18
 * @description 序列化
 * 序列化：将对象写入到IO流中
 * 反序列化：从IO流中恢复对象
 * Serializable接口是一个「标记接口」，不用实现任何方法，标记当前类对象是可以序列化的，是给JVM看的。
 */

@SuppressWarnings("all")
public class SerializableDemo {

    public static void main(String[] args) throws Exception {
        testSerializablePeople();
    }


    public static void testSerializablePeople() throws Exception{
        // =====序列化的步骤=====
        // 用于存储序列化的文件people_10.java_，这里的java_下划线仅仅为了说明是java序列化对象，没有任何其他含义
        String filePath = GetPath.getFilePath();
        File file = new File(filePath + "\\files\\people_10.java_");
        if (!file.exists()) {
            // 1、先得到文件的上级目录，并创建上级目录
            file.getParentFile().mkdirs();
            try {
                // 2、再创建文件
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        People p = new People(10L);

        // 创建一个输出流
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        // 输出可序列化对象
        oos.writeObject(p);
        // 关闭输出流
        oos.close();

        // =====反序列化的步骤=====
        // 创建一个输入流
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        // 得到反序列化的对象，这里可以强转为People类型
        Object newPerson = ois.readObject();
        // 关闭输入流
        ois.close();
        System.out.println(newPerson);
    }
}
