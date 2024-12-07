package mix.generics_example;

/**
 * @author weimenghua
 * @time 2024-11-19 11:04
 * @description
 */
// 定义一个泛型类 Box
public class Box<T> {
    private T item;

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }
}
