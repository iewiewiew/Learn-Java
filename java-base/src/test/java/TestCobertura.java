import org.junit.Test;
import utils.CoberturaDemo;

/**
 * @author weimenghua
 * @time 2022-09-17 07:24
 * @description 测试Cobertura
 */
public class TestCobertura {
    @Test
    public void test01(){
        CoberturaDemo coberturaDemo = new CoberturaDemo();
        int result = coberturaDemo.add(1, 2);
        System.out.printf(String.valueOf(result));
    }
}
