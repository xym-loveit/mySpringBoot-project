在类WebMvcAutoConfiguration中，注册了messageConverters，代码如下：
```
@Autowired
private HttpMessageConverters messageConverters;
@Override
public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
    converters.addAll(this.messageConverters.getConverters());
}

```

在这里直接注入了HttpMessageConverters 的Bean，而这个Bean是在HttpMessageConvertersAutoConfiguration类中定义的，自动注册的HttpMessageConverter除了Spring MVC默认的ByteArrayHttpMessageConverter,StringHttpMessageConverter,ResourceHttpMessageConverter,SourceHttpMessageConverter,AllEncodingpassingFormHttpMessageConverter外，在HttpMessageConvertersAutoConfiguration的自动配置文件里还引入了JacksonHttpMessageConvertersAutoConfiguration和GsonHttpMessageConvertersAutoConfiguration,使我们获得了额外的JacksonHttpMessageConverter：

>
> 1. 若Jackson的jar包在类路径上，则Spring Boot通过JacksonHttpMessageConvertersAutoConfiguration增加MappingJackson2HttpMessageConverter
> 和MappingJackson2XmlHttpMessageConverter。
> 2. 若gson的jar包在类路径上，则Spring Boot通过GsonHttpMessageConvertersAutoConfiguration增加GsonHttpMessageConverter
>

在Spring Boot中，如果要新增自定义的HttpMessageConverter,则只需要定义一个自己的HttpMessageConverters的Bean，然后再此Bean中注册自定义的HttpMessageConverter即可，例如：
```
@Bean
public HttpMessageConverters customConverters{
    HttpMessageConverter<?> customConverter1 = new CustomConverter1();
    HttpMessageConverter<?> customConverter2 = new CustomConverter2();
    return new HttpMessageConverters(customConverter1,customConverter2);
}

```
