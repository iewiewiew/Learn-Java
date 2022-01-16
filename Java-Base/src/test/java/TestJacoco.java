import org.junit.Test;
import tool.JacocoDemo;

/**
 * @author weimenghua
 * @time 2022-09-16 22:55
 * @description 测试Jacoco
 */
public class TestJacoco {
    @Test
    public void test01() {
        JacocoDemo jacocoDemo = new JacocoDemo();
        int result = jacocoDemo.add(1, 2);
        System.out.printf(String.valueOf(result));
    }
}
