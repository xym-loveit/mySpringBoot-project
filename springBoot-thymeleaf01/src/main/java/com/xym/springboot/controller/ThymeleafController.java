package com.xym.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author xym
 */
@Controller
public class ThymeleafController {

    @RequestMapping("thymeleaf")
    public String hello(Model model) {
        model.addAttribute("name", "张三");
        return "hello_thymeleaf";
    }

}
