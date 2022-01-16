package org.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @author weimenghua
 * @time 2023-01-24 15:40
 * @description 日志切面
 */

@Aspect
@Component
public class LogAspect {

    /**
     * execution(方法修饰符(可选)  返回类型  方法名  参数  异常模式(可选))
     */
    @Pointcut("execution(public * org.example.controller.*.*(..))")
    public void webLog(){}

    @Before("webLog()")
    public void deBefore(JoinPoint joinPoint) throws Throwable {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 记录请求内容如下
        System.out.printf("URL：" + request.getRequestURL().toString());
        System.out.println("HTTP_METHOD : " + request.getMethod());
        System.out.println("IP : " + request.getRemoteAddr());
        System.out.println("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        System.out.println("ARGS : " + Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable{
        // 处理完请求，返回内容
        System.out.printf("方法的返回值：" + ret);
    }

    // 后置异常通知
    @AfterThrowing("webLog()")
    public void throwss(JoinPoint jp){
        System.out.printf("方法异常时执行......");
    }

    // 后置最终通知, final增强，不管是抛出异常或者正常退出都会执行
    @After("webLog()")
    public void after(JoinPoint jp){
        System.out.printf("方法最后执行......");
    }

    // 环绕通知, 环绕增强，相当于MethodInterceptor
    @Around("webLog()")
    public Object arround(ProceedingJoinPoint pjp){
        System.out.printf("方法环绕start......");
        try {
            Object o = pjp.proceed();
            System.out.printf("方法环绕proceed，结果是：" + o);
            return o;
        } catch (Throwable e){
            e.printStackTrace();
            return null;
        }
    }

}
