package mix.generics_example;

/**
 * @author weimenghua
 * @time 2024-11-19 11:38
 * @description
 */
//泛型方法示例
public class GenericMethodExample {
//    <E>: 这是一个类型参数声明，表示该方法是一个泛型方法。E 是一个类型参数，可以用来表示任何类型。在此方法中，它代表传入数组中元素的类型。
//    printArray(E[] array): 方法接受一个参数 array，其类型为 E[]，表示一个泛型数组。数组中的元素类型由调用该方法时传入的类型参数 E 决定。
    public static <E> void printArray(E[] array) {
        for (E element : array) {
            System.out.println(element);
        }
    }
}
