import org.junit.Ignore;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author      weimenghua
 * @time        2022-02-23 14:36
 * @description 单元测试
 */
public class TestDemo {
    public static void main(String[] args) {
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }
    @Test
    public void test01(){
        assert 1==1;
        System.out.printf("成功用例");
    }
    @Test
    public void test02(){
        assert 1==2;
        System.out.printf("失败用例");
    }
    @Test
    @Ignore("忽略除法测试，因为会抛异常")
    public void test03(){
        assert 1==1;
        System.out.printf("跳过用例");
    }
}
