package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author weimenghua
 * @time 2023-01-24 16:11
 * @description
 *
 * 参考资料：https://gitee.com/yidao620/springboot-bucket/tree/master/springboot-aop
 *
 * 切面注解说明
 * @Aspect 作用是把当前类标识为一个切面供容器读取
 * @Pointcut 定义切点，切点方法不用任何代码，返回值是void，重要的是条件表达式
 * @Before 标识一个前置增强方法，相当于BeforeAdvice的功能
 * @AfterReturning 后置增强，相当于AfterReturningAdvice，方法退出时执行
 * @AfterThrowing 异常抛出增强，相当于ThrowsAdvice
 * @After final增强，不管是抛出异常或者正常退出都会执行
 * @Around 环绕增强，相当于MethodInterceptor
 */

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
