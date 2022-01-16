package utils;

import java.io.*;

public class CallExe {

    public static void main(String[] args) throws IOException {
        CallExe callExe = new CallExe();

        String exePath1 = "D:\\workspace\\MobaXterm\\MobaXterm.exe";
        String exePath2 = "D:\\software\\Navicat Premium 12\\navicat.exe";
        callExe.CallEXE("navicat");
    }

    public void CallEXE(String path) throws IOException {
        Runtime runtime = Runtime.getRuntime();
        runtime.exec(path);
    }
}
