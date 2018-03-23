package com.xym.springboot.annotation;

import java.lang.annotation.*;

/**
 * 拦截规则的注解
 */
@Target({ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Action {
    String value() default "";
}
