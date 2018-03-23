package com.xym.springboot.xml.scan;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xym
 */
@RestController
@RequestMapping("/pro")
public class PropertiesController {

    /**
     * 直接使用@Value注入常规属性值即可
     */
    @Value("${article.author}")
    private String articleAuthor;
    @Value("${article.name}")
    private String articleName;

    @RequestMapping
    public String hello() {
        return "article name is:" + articleName + " and article author is:" + articleAuthor;
    }

}
