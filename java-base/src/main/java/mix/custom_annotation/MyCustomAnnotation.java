package mix.custom_annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author weimenghua
 * @time 2024-12-02 11:13
 * @description 自定义注解
 */

// 定义自定义注解
@Retention(RetentionPolicy.RUNTIME) // 运行时保留
@Target({ElementType.METHOD, ElementType.FIELD}) // 可以用于方法和类
public @interface MyCustomAnnotation {
    String value() default  "default value";
    String author() default "unknown";
    String date();
    int version() default 1;
}
