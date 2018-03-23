package com.xym.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Profile是Spring用来针对不同的环境对不同的配置提供支持的，全局Profile配置使用application-{profile}.properties(如application-prod.properties)。
 * <p>
 * 通过在application.properties中设置spring.profiles.active的值来指定活动的Profile配置
 *
 * @author xym
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
