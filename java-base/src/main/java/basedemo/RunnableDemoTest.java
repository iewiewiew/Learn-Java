package basedemo;

/**
 * @Author weimenghua
 * @Date 2022-02-26 12:36
 * @Description
 */
public class RunnableDemoTest {
    public static void main(String[] args) {
        RunnableDemo R1 = new RunnableDemo( "Thread-1");
        R1.start();

        RunnableDemo R2 = new RunnableDemo( "Thread-2");
        R2.start();
    }
}
