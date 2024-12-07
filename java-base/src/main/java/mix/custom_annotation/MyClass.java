package mix.custom_annotation;

/**
 * @author weimenghua
 * @time 2024-12-02 13:58
 * @description 使用自定义注解
 */
public class MyClass {

    @MyCustomAnnotation(value = "This is an annotated method", author = "Alice", date = "2024-12-01")
    public void myAnnotatedMethod() {
        System.out.println("Executing annotated method.");
    }

    @MyCustomAnnotation(author = "Bob", date = "2024-12-02")
    public void anotherAnnotatedMethod() {
        System.out.println("Executing another annotated method.");
    }
}
