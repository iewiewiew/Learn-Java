package utils;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.captcha.generator.RandomGenerator;
import cn.hutool.core.lang.Console;
import org.junit.Test;

import java.io.IOException;


/**
 * 验证码
 */
public class CCaptchaUtil {
    public static void main(String[] args) throws Exception {
        String path1 = GetPath.getFilePath() + "\\files\\lineCaptcha.png";
        String path2 = GetPath.getFilePath() + "\\files\\lineCaptcha.png";

        CCaptchaUtil.test1(path1);
        CCaptchaUtil.test2(path2);
    }

    public static void test1(String path) throws IOException {
        CaptchaUtil.createLineCaptcha(300, 100, 6, 100).write(path);
    }

    public static void test2(String path) throws Exception {
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(300, 100, 6, 100);
        RandomGenerator randomGenerator = new RandomGenerator("0123456789", 6);
        lineCaptcha.setGenerator(randomGenerator);
        String lineCaptchaCode = lineCaptcha.getCode();
        Console.log("lineCaptchaCode", lineCaptchaCode);
        lineCaptcha.write(path);
    }
}