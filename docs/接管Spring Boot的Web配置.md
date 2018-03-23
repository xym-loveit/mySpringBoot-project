如果Spring Boot提供的Spring MVC默认配置不符合你的要求，则可以通过一个配置类(注解有@Configuration的类)加上@EnableWebMvc注解来实现完全自己控制的MVC配置。

当然，通常情况下，Spring Boot的自动配置是符合我们的大多数需求的。在你既要保留Spring Boot提供的便利，又要增加自己的额外的配置的时候，可以定义一个配置类并继承WebMvcConfigureAdapter，无须使用@EnableWebMvc注解，然后参考之前讲解Spring MVC的文章SpringMvc4.x基本配置(四):快捷的ViewController来配置方法来添加Spring Boot为我们所做的其他配置，例如：
```

@Configuration
public class WebMvcConfig extends WebMvcConfigureAdapter{
   @Override
   public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("/index");
   }
}

```
值得指出的，在这里重写addViewControllers方法，并不会覆盖WebMvcAutoConfiguration中的addViewController,在此方法中，Spring Boot将”/index”映射至index.html，这也就意味着我们自己的配置和Spring Boot的自动配置同时有效，这也是我们推荐自己添加的MVC配置的方式