package utils;

import com.jcraft.jsch.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

/**
 * JSch是Java Secure Channel的缩写。 JSch是一个SSH2的纯Java实现。它允许你连接到一个SSH服务器，并且可以使用端口转发，X11转发，文件传输等
 */

public class SftpUtils {

    public static String HOST = "127.0.0.1";
    public static int PORT = 22;
    public static String USERNAME = "username";
    public static String PASSWORD = "password";

    public static void main(String[] args) throws Exception{

        String filePath = GetPath.getFilePath() + "\\files";

        //服务器文件路径
        String directory = "/tmp/";
        //上传文件
        String uploadFile = filePath + "\\demo.csv";
        //下载文件
        String downloadFile = "xxx.pdf";
        //保存文件路径 注:需要写文件名称,否则会报错拒绝访问
        String saveFile = filePath + downloadFile;

        SftpUtils sf = new SftpUtils();

        //ChannelSftp类是JSch实现SFTP核心类，它包含了所有SFTP的方法
        ChannelSftp sftp = sf.connect(HOST, PORT, USERNAME, PASSWORD);

        sf.download(directory, downloadFile, saveFile, sftp);

        sf.upload(directory, uploadFile, sftp);
    }


    /**
     * 连接sftp服务器
     * @param host 主机
     * @param port 端口
     * @param username 用户名
     * @param password 密码
     * @return
     */
    public ChannelSftp connect(String host, int port, String username,
                               String password) {
        ChannelSftp sftp = null;
        try {
            JSch jsch = new JSch();
            jsch.getSession(username, host, port); //根据用户名，主机ip，端口获取一个Session对象
            Session sshSession = jsch.getSession(username, host, port);
            System.out.println("Session created.");
            sshSession.setPassword(password); // 设置密码
            Properties sshConfig = new Properties();
            sshConfig.put("StrictHostKeyChecking", "no");
            sshSession.setConfig(sshConfig);
            sshSession.connect();
            System.out.println("Session connected.");
            System.out.println("Opening Channel.");
            Channel channel = sshSession.openChannel("sftp");
            channel.connect();
            sftp = (ChannelSftp) channel;
            System.out.println("Connected to " + host + ".");
        } catch (Exception e) {

        }
        return sftp;
    }


    /**
     * 下载文件
     * @param directory 下载目录
     * @param downloadFile 下载的文件
     * @param saveFile 存在本地的路径
     * @param sftp
     */
    public void download(String directory, String downloadFile,String saveFile, ChannelSftp sftp) {
        try {
            sftp.cd(directory);
            File file=new File(saveFile);
            sftp.get(downloadFile, new FileOutputStream(file));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 上传文件
     * @param directory 上传的目录
     * @param uploadFile 要上传的文件
     * @param sftp
     */
    public void upload(String directory, String uploadFile, ChannelSftp sftp) {
        try {
            sftp.cd(directory);
            File file=new File(uploadFile);
            sftp.put(new FileInputStream(file), file.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 删除文件
     * @param directory 要删除文件所在目录
     * @param deleteFile 要删除的文件
     * @param sftp
     */
    public void delete(String directory, String deleteFile, ChannelSftp sftp) {
        try {
            sftp.cd(directory);
            sftp.rm(deleteFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
