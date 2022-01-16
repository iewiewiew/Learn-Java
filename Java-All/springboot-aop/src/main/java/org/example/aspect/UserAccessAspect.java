package org.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author weimenghua
 * @time 2023-01-24 16:28
 * @description
 */

@Aspect
@Component
public class UserAccessAspect {

    @Pointcut(value = "@annotation(org.example.aspect.UserAccess)")
    public void access(){

    }

    @Before("access()")
    public void doBefore(JoinPoint joinPoint) throws Throwable{
        System.out.printf("second before");
    }

    @Around("@annotation(userAccess)")
    public Object around(ProceedingJoinPoint pjp, UserAccess userAccess){
        // 获取注解里面的值
        System.out.printf("second around：" + userAccess.desc());
        try{
            return pjp.proceed();
        }catch (Throwable throwable){
            throwable.printStackTrace();
            return null;
        }
    }
}
