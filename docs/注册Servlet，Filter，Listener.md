当使用嵌入式的Servlet容器(Tomcat，Jetty等)时，我们通过将Servlet,Filter和Listener声明为Spring Bean而达到注册的效果；或者注册ServletRegistrationBean,FilterRegistrationBean,ServletListenerRegistrationBean的Bean。

### 1. 直接注册Bean示例，代码如下：

```

@Bean
public XxServlet xxServlet(){
       return new XxServlet;
}

@Bean
public YyFilteryyFilter(){
    return new YyFilter;
}

@Bean
public ZzListener zzListener (){
    return new ZzListener ;
}

```

### 2.通过RegistrationBean示例

```

@Bean
public ServletRegistrationBean servletRegistrationBean(){
    return new ServletRegistrationBean(new XxServlet(),"/xx/*");
}

@Bean
public FilterRegistrationBean filterRegistrationBean(){
    FilterRegistrationBean registrationBean = new FilterRegistrationBean();
    registrationBean.setFilter(new YyFilter());
    registrationBean.setOrder(2);
    return registrationBean;
}

@Bean
public ServletListenerRegistrationBean<ZzListener> zzListenerRegistrationBean(){
    return new ServletListenerRegistrationBean<ZzListener>(new ZzListener());
}

```
