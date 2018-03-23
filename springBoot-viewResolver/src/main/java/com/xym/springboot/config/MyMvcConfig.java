package com.xym.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


/**
 * @author xym
 */
@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {

   /* @Bean
    public BeanNameViewResolver viewResolver() {
        BeanNameViewResolver beanNameResolver = new BeanNameViewResolver();
        return beanNameResolver;
    }

    @Bean
    public MappingJackson2JsonView jsonView() {
        MappingJackson2JsonView jsonView = new MappingJackson2JsonView();
        return jsonView;
    }*/

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("/index.html");
    }
}
