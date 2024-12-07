package basedemo;

/**
 * @author weimenghua
 * @date 2021-11-20 10:46
 */

/**
 * 重写toString，object类里的toString只是把字符串的直接打印，数字的要转化成字符再打印，而对象，则直接打印该对象的hash码。
 * 如果在类中没有重写ToString方法，默认使用的是Object的toString方法输出格式。这个时候，对象就会直接显示hash码。
 */
public class ToStringDemoTest {
    public static void main(String[] args) {
        ToStringDemo toStringDemo = new ToStringDemo();
        System.out.println(toStringDemo);

        System.out.println("重写toString：ToStringDemo{id=0, name='null', age=0}");
        System.out.println("不重写toString：basedemo.ToStringDemo@191083d");
    }
}
