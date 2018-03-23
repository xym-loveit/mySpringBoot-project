package com.xym.springboot.controller;

import com.xym.springboot.annotation.Action;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xym
 * @Action注解加在方法hello()上面
 */
@RestController
@RequestMapping
public class HelloController {

    @RequestMapping
    @Action("hello")
    public String hello() {
        return "Hello Spring Boot";
    }

}
