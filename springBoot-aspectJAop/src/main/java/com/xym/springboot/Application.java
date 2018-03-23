package com.xym.springboot;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * OP是Spring框架中的一个重要内容，在Spring boot里配置aop非常简单，Spring Boot对AOP的默认配置属性是开启的，也就是说spring.aop.auto属性的值默认是true，我们只要引入了AOP依赖后，默认就已经增加了@EnableAspectJAutoProxy功能，不需要我们在程序启动类上面加入注解@EnableAspectJAutoProxy。
 * <p>
 * Spring Aop的相关内容可以参考前面的文章Spring4.x基础配置(三):Spring AOP
 * <p>
 * 下面将使用Spring Boot通过模拟记录操作日志来演示基于注解拦截的AOP实现方式
 *
 * @author xym
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        new SpringApplicationBuilder(Application.class).bannerMode(Banner.Mode.OFF).build().run(args);
    }

}
