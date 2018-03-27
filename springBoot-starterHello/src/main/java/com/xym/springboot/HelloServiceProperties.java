package com.xym.springboot;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 类型安全属性配置,在application.properties中通过hello.msg=来设置，若不设置，默认为
 * hello.msg=world
 *
 * @author xym
 */
@ConfigurationProperties(prefix = "hello")
public class HelloServiceProperties {
    private static final String MSG = "world";

    private String msg = MSG;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
