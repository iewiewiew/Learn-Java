package basedemo;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RegexDemo {
    public static void main(String[] args) {
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss" ).format(new Date()));
    }


    /**
     * 正则表达式匹配
     */
    @Test
    public void test1(){
        String regex = "20\\d\\d";
        String[] str = {"1234","2021","2022"};

        for (int i = 0; i < str.length; i++){
            if (str[i].matches(regex)){
                System.out.println(str[i] + " 匹配成功");
            }else{
                System.out.println(str[i] + " 匹配失败");
            }
        }
    }


    /**
     * 替换字符串：String.replaceAll()
     */
    @Test
    public void test2(){
        String regex = "\\s+";
        String str = "我   想     发   财";
        String newStr = str.replaceAll(regex," ");
        System.out.println("替换后的字符串：" + newStr);
    }
}
