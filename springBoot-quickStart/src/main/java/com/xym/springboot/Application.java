package com.xym.springboot;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * ① @SpringBootApplication 是Spring Boot项目的核心注解，主要目的是开启自动配置。
 * ② 这是一个标准的Java应用的main方法，主要作用是作为项目启动的入口。
 * <p>
 * <p>
 * 可以采用命令mvn spring-boot:run 运行
 *
 * @author xym
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
//        SpringApplication.run(Application.class, args);


        /*关闭banner*/
        /*SpringApplication springApplication = new SpringApplication(Application.class);
        springApplication.setBannerMode(Banner.Mode.OFF);
        springApplication.run(args);*/

        new SpringApplicationBuilder(Application.class).run(args);

    }
}
