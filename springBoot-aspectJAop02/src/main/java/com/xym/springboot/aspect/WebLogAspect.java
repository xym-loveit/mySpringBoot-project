package com.xym.springboot.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.logging.Logger;

/**
 * Order中的参数值越低优先级越高
 * <p>
 * * 在切入点前的操作，按order的值由小到大执行
 * 在切入点后的操作，按order的值由大到小执行
 *
 * @author xym
 */
@Aspect
@Component
@Order(2)
public class WebLogAspect {

    private Logger logger = Logger.getLogger("WebLogAspect");

    ThreadLocal<Long> startTime = new ThreadLocal<>();

    /**
     * 拦截controller包下面的所有类所有方法
     */
    @Pointcut("execution(public  * com.xym.springboot.controller..*.*(..))")
    public void weLog() {
    }

    @Before("weLog()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        startTime.set(System.currentTimeMillis());
        // 记录下请求内容
        logger.info("URL : " + request.getRequestURL().toString());
        logger.info("HTTP_METHOD : " + request.getMethod());
        logger.info("IP : " + request.getRemoteAddr());
        logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
    }


    @AfterReturning(returning = "ret", pointcut = "weLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        logger.info("RESPONSE : " + ret);
        logger.info("SPEND TIME : " + (System.currentTimeMillis() - startTime.get()));

    }

}
