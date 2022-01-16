package utils;

import cn.hutool.extra.qrcode.QrCodeUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.extra.qrcode.QrConfig;

import java.awt.*;
import java.io.IOException;

/**
 * 二维码
 */
public class QQCodeUtil {
    public static void main(String[] args) throws IOException {
        String path = GetPath.getFilePath() + "\\files\\QRTest.jpeg";
        String imgPath = GetPath.getFilePath() + "\\files\\sea.jpeg";
        String URL = "http://www.baidu.com";
        QQCodeUtil.GetQR(URL, path);
//        QQrCodeUtil.GetQR2(URL, imgPath, path);
//        QQrCodeUtil.GetQR3(URL, path);
        QQCodeUtil.analysisQRcode(path);
    }

    public static String GetQR(String URL, String path) {
        QrCodeUtil.generate(URL, 500, 500, FileUtil.file(path));
        return "生成成功";
    }

    public static String GetQR2(String URL, String imgPath, String path) {
        QrCodeUtil.generate(URL, QrConfig.create().setImg(imgPath), FileUtil.file(path));
        return "生成成功";
    }

    public static String GetQR3(String URL, String path) {
        QrConfig config = new QrConfig(300, 300);
        // 设置边距，既二维码和背景之间的边距
        config.setMargin(3);
        // 设置前景色，既二维码颜色（青色）
        config.setForeColor(Color.CYAN);
        // 设置背景色（灰色）
        config.setBackColor(Color.GRAY);
        // 生成二维码到文件，也可以到流
        QrCodeUtil.generate(URL, config, FileUtil.file(path));
        return "生成成功";
    }

    public static String analysisQRcode(String path) {
        String decode = QrCodeUtil.decode(FileUtil.file(path));
        System.out.println("地址为：" + decode);
        return "解析成功：" + decode;
    }
}
