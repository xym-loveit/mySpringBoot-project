package com.xym.springboot.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xym
 */
@RestController
public class HelloController {
    @RequestMapping("/")
    public String hello() {
        return "Hello Spring Boot";
    }
}
