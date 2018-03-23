package com.xym.springboot;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author xym
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        args = new String[]{"--server.port=8111"};
        new SpringApplicationBuilder(Application.class).bannerMode(Banner.Mode.OFF).run(args);
    }
    
}
