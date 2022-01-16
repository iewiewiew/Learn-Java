package basedemo;

public class MessageEnumTest {
    public static void main(String[] args) {
        MessageEnum message = MessageEnum.SYSTEM;    //每个枚举成员实际上是一个枚举实例
        System.out.println("type：" + message.getType());
        System.out.println("desc：" + message.getDesc());
    }
}
