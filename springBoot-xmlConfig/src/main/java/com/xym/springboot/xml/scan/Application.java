package com.xym.springboot.xml.scan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * Spring Boot提倡零配置，即无xml配置，但是在实际项目中，可能有一些特殊要求你必须使用xml配置，这时候可以通过在配置类上面使用Spring提供的@ImportResource来在加载xml配置
 * <p>
 * 特殊情况下通过引用xml的方式实例化bean
 *
 * @author xym
 */
@SpringBootApplication
@ImportResource(value = {"classpath:config/application-bean.xml"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
