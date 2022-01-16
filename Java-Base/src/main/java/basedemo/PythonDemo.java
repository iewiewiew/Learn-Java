package basedemo;

import org.junit.Test;
import org.python.util.PythonInterpreter;
import utils.GetPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author weimenghua
 * @time 2022-04-01 14:01
 * @description Java调用Python脚本
 */
public class PythonDemo {
    public static void main(String[] args) {
        System.out.printf("");
    }

    @Test
    public void executePython() {
        // 一条简单的 python 语句，打印 Hello world !
        String py = "print('Hello world!')";
        PythonInterpreter interpreter = new PythonInterpreter();
        // 执行 Python 语句
        interpreter.exec(py);
    }

    @Test
    public void executePythonFile() throws IOException {
        // 定义脚本路径
        String path = GetPath.getFilePath() + "\\files\\testpython.py";
        PythonInterpreter interpreter = new PythonInterpreter();
        // 执行脚本文件
        interpreter.execfile(path);
    }

    @Test
    public void executePythonFile2() {
        Process proc;
        BufferedReader reader;
        try {
            // 直接执行 python 命令的方式来执行脚本
            proc = Runtime.getRuntime().exec("python GetPath.getFilePath() + '\\files\\testpython.py'");
            reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));

            String line = null;
            while ((line = reader.readLine()) != null) {
                // 打印输出
                System.out.println(line);
            }

            reader.close();
            proc.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
