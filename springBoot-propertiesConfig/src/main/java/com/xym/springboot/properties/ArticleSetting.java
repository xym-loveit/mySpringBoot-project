package com.xym.springboot.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


/**
 * Spring Boot还提供了基于类型安全的属性配置方式，通过@ConfigurationProperties将properties属性和一个Bean及其属性关联，从而实现类*型安全的配置。
 * <p>
 * ① 通过ConfigurationProperties加载properties文件内的配置，通过prefix属性指定properties的配置的前缀，通过locations指定properties文件的位置，例如：
 * <p>
 * <p>
 * 配置如果在application.properties文件里面，可以不需要配置locations属性
 * <p>
 * locations里指定properties的位置
 *
 * @author xym
 */
@Component
@ConfigurationProperties(prefix = "article", locations = {"classpath:properties/article.properties"})
public class ArticleSetting {
    private String name;
    private String author;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
