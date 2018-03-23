package com.xym.springboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xym
 */
@RestController
@RequestMapping("pro")
public class PropertiesController {

    @Value("${article.name}")
    public String articleName;
    @Value("${article.author}")
    public String articleAuthor;

    @RequestMapping
    public String hello() {
        return "articleName:" + articleName + ",articleAuthor=" + articleAuthor;
    }


}
