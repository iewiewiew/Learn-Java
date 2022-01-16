package algorithm;

/**
 * @Author weimenghua
 * @Date 2022-02-26 11:23
 * @Description 鸡兔同笼
 */
public class JTTL {
    public static void main(String[] args) {
        JTTL jttl = new JTTL();
        jttl.jttl(35, 94);
    }

    /**
     * x + y = head
     * 2*x + 4*y = foot
     * x 鸡数量
     * y 兔数量
     * @param head 头数量
     * @param foot 交数量
     */
    public static void jttl(int head, int foot) {
        int x, y;

        if (foot % 2 == 0) {
            x = 2 * head - foot / 2;
            y = head - x;

            if (x >= 0 && y >= 0) {
                System.out.println("鸡的数量为：" + x + "，兔的数量为：" + y);
            } else {
                System.out.println("不存在此分配方案！");
            }

        } else {
            System.out.println("不存在此分配方案！");
        }
    }
}
