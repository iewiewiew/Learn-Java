package mix.generics_example;

/**
 * @author weimenghua
 * @time 2024-11-19 13:49
 * @description
 */
public class Main {
    public static void main(String[] args) {
//        创建一个 Box 对象，并指定类型为 String
        Box<String> stringBox = new Box<>();
        stringBox.setItem("Hello");
        System.out.println("String Box:" + stringBox.getItem());

//        创建一个 Box 对象，并指定类型为 String
        Box<Integer> integerBox = new Box<>();
        integerBox.setItem(123);
        System.out.println("Integer Box:" + integerBox.getItem());

//        使用泛型打印数组
        String[] stringArray = {"Apple", "Banana", "Cherry"};
        Integer[] integerArray = {1, 2, 3};

        GenericMethodExample.printArray(stringArray);
        GenericMethodExample.printArray(integerArray);
    }
}
