package utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

/**
 * @Author weimenghua
 * @Date 2022-06-18 10:17
 * @Description URL编码解码
 *
 * URL编码解码在线网站： http://tool.chinaz.com/tools/urlencode.aspx
 * url链接粘贴下来后通常会出现类似%E4%BD%A0%E5%A5%BD的编码，一般来说一个中文字对应三个%编码的是utf-8, 一个中文字对应两个%编码的是GB2312。
 * encode的作用是将unicode编码转换成其他编码的字符串，如str2.encode('gb2312')，表示将unicode编码的字符串str2转换成gb2312编码。
 * decode的作用是将其他编码的字符串转换成unicode编码，如str1.decode('gb2312')，表示将gb2312编码的字符串str1转换成unicode编码。
 */
public class CodeUtil {
    public static void main(String[] args) {
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss" ).format(new Date()));
    }


    @Test
    public void test() throws UnsupportedEncodingException{
        String str = "字符串啊啊啊";

        String encodeStr = URLEncoder.encode(str, "UTF-8");
        System.out.println("编码：" + encodeStr);

        String decodeStr = URLDecoder.decode(str, "UTF-8");
        System.out.println("解码：" + decodeStr);
    }
}
