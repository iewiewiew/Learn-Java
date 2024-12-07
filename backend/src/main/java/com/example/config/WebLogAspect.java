package com.example.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;

/**
 * 打印日志类
 */
@Aspect
@Configuration
@Slf4j
public class WebLogAspect {

    ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 定义切点 切点为com.example.controller下所有的类
     * 其中类里的所有方法为连接点
     */
    @Pointcut("execution(* com.example.controller..*.*(..))")
    public void webLog() {
    }

    /**
     * 环绕通知
     * Object getTarget：获取被代理的对象
     * Signature getSignature：返回目标方法的签名对象
     * Object[] getArgs：返回目标方法的参数
     * Object proceed：执行目标方法
     */
    @Around(value = "webLog()")
    public Object webLogAround(ProceedingJoinPoint joinPoint) throws Throwable {
        //className的值：com.controller.example.DemoController
        String className = joinPoint.getTarget().getClass().getName();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        //方法名称示例：com.controller.example.DemoController.allDemo()
        String methodName = new StringBuffer(className.replaceFirst("test.", ""))
                .append(".")
                .append(signature.getMethod().getName())
                .append("():").toString();
        log.info("==> {} 方法请求报文:{}", methodName, objectMapper.writeValueAsString(joinPoint.getArgs()));
        Object proceed = joinPoint.proceed();
        log.info("==> {} 方法响应报文:{}", methodName, objectMapper.writeValueAsString(proceed));
        return proceed;
    }
}