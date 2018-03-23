通过查看WebMvcAutoConfiguration以及WebMvcProperties的源码，可以发现Spring为我们提供了相关的自动配置，下面分几个部分来介绍这些自动配置。

### (一) ContentNegotiatingViewResolver

这是Spring MVC提供的一个特殊的ViewResolver，ContentNegotiatingViewResolver不是自己处理View，而是代理给不同的ViewResolver来处理不同的View，所以它有最高的优先级。

### (二) BeanNameViewResolver

在控制器(@Controller)中的一个方法返值的字符串(视图名)会根据BeanNameViewResolver去查找Bean的名称为返回字符串的View来渲染视图，下面举个例子：
```
@Bean
public BeanNameViewResolver beanNameViewResolver(){
    BeanNameViewResolver resolver = new BeanNameViewResolver();
    return resolver;
}

```

定义一个View的Bean，名称为jsonView：
```
@Bean
public MappingJackson2JsonView jsonView(){
    MappingJackson2JsonView jsonView = new MappingJackson2JsonView();
    return jsonView;
}

```
在控制器中，返回值为字符串jsonView，它会找Bean的名称为jsonView的视图来渲染：
```
@RequestMapping(value = "json",produces={MediaType.APPLICATION_JSON_VALUE})
public String json(Model model){
    Person single =new Person("aa",11);
    model.addAttribute("single", single);
    return "jsonView";
}
```
### 三 InternalResourceViewResolver

这个是一个极为常用的ViewResolver，主要通过设置前缀，后缀，以及控制器中方法来返回视图名的字符串，以得到实际页面，SpringBoot中在类WebMvcAutoConfiguration的源码如下：
```
@Bean
@ConditionalOnMissingBean(InternalResourceViewResolver.class)
public InternalResourceViewResolver defaultViewResolver() {
    InternalResourceViewResolver resolver = new InternalResourceViewResolver();
    resolver.setPrefix(this.prefix);
    resolver.setSuffix(this.suffix);
    return resolver;
}
```