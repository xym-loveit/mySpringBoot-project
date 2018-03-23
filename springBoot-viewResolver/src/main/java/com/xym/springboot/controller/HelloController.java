package com.xym.springboot.controller;


import com.xym.springboot.domain.Person;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xym
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping(value = "json", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public String json(Model model) {
        Person single = new Person(1000L, "张三");
        model.addAttribute("single", single);
        return "jsonView";
    }

}
