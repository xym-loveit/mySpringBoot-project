package com.xym.springboot.aspect;

import com.xym.springboot.annotation.Action;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * ①通过@Aspect注解声明该类是一个切面。
 * ②通过@Component让此切面成为Spring容器管理的Bean。
 * ③通过@Pointcut注解声明切点。
 * ④通过@AfterReturning注解声明一个增强，并使用@Pointcut定义的切点。
 * ⑤通过反射可以获得注解上面的属性，然后做日志记录相关的操作，下面的相同。
 * ⑥通过@Before注解声明一个建言，此建言直接使用拦截规则作为参数。
 *
 * @author xym
 */
@Aspect
@Component
public class LogAspect {

    /**
     * 定义切点
     */
    @Pointcut("@annotation(com.xym.springboot.annotation.Action)")
    public void log() {
    }

    /**
     * 前置通知
     */
    @Before("log()")
    public void doBeforeController(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Action action = method.getAnnotation(Action.class);
        System.out.println("action名称 " + action.value());
    }

    /**
     * 后置通知
     */
    @AfterReturning(pointcut = "log()", returning = "retValue")
    public void doAfterController(JoinPoint joinPoint, Object retValue) {
        System.out.println(">>>>>>>" + joinPoint.getTarget().toString());
        System.out.println("retValue is:" + retValue);
    }

}
