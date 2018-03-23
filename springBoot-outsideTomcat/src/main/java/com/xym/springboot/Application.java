package com.xym.springboot;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author xym
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {

        new SpringApplicationBuilder(Application.class).run(args);

    }
}
