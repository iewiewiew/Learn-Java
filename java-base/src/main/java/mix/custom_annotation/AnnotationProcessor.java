package mix.custom_annotation;

import java.lang.reflect.Method;

/**
 * @author weimenghua
 * @time 2024-12-05 10:19
 * @description 读取自定义注解
 */

public class AnnotationProcessor {
    public static void main(String[] args) {
        // Class<MyClass> 是一个泛型类型，这意味着 obj 变量将只引用 MyClass 类型的类对象。
        // MyClass.class 是一种语法，用于获取 MyClass 的 Class 对象。
        Class<MyClass> obj = MyClass.class;

        // 处理类级别注释
        if (obj.isAnnotationPresent(MyCustomAnnotation.class)) {
            MyCustomAnnotation annotation = obj.getAnnotation(MyCustomAnnotation.class);

            System.out.println("Class annotation value: " + annotation.value());
            System.out.println("Author: " + annotation.author());
            System.out.println("Date: " + annotation.date());
            System.out.println("Version: " + annotation.version());
        }

        // 处理方法级别注释
        for (Method method: obj.getDeclaredMethods()) {
            if (method.isAnnotationPresent(MyCustomAnnotation.class)) {
                MyCustomAnnotation annotation = method.getAnnotation(MyCustomAnnotation.class); // 修改这里

                System.out.println("Method: " + method.getName());
                System.out.println("Class annotation value: " + annotation.value());
                System.out.println("Author: " + annotation.author());
                System.out.println("Date: " + annotation.date());
                System.out.println("Version: " + annotation.version());
            }
        }
    }
}
