package basedemo;

/**
 * @Author weimenghua
 * @Date 2022-02-26 12:41
 * @Description
 */
public class ThreadDemoTest {
    public static void main(String args[]) {
        ThreadDemo T1 = new ThreadDemo( "Thread-1");
        T1.start();

        ThreadDemo T2 = new ThreadDemo( "Thread-2");
        T2.start();
    }
}
