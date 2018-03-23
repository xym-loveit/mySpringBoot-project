package com.xym.springboot.controller;

import com.xym.springboot.properties.ArticleSetting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 可以用@Autowired直接注入该配置
 * <p>
 * 新建一个properties文件，这就需要我们在@ConfigurationProperties的属性locations里指定properties的位置
 *
 * @author xym
 */
@RestController
@RequestMapping("/proNew")
public class PropertiesControllerNew {
    @Autowired
    private ArticleSetting articleSetting;

    @RequestMapping
    public String hello() {
        return "name=" + articleSetting.getName() + ",author=" + articleSetting.getAuthor();
    }

}
