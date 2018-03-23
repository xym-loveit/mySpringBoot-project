关于自动配置Formatter和Converter，可以看下WebMvcAutoConfiguration类中的定义：

```
@Override
public void addFormatters(FormatterRegistry registry) {
            for (Converter<?, ?> converter : getBeansOfType(Converter.class)) {
                registry.addConverter(converter);
            }

            for (GenericConverter converter : getBeansOfType(GenericConverter.class)) {
                registry.addConverter(converter);
            }

            for (Formatter<?> formatter : getBeansOfType(Formatter.class)) {
                registry.addFormatter(formatter);
            }
        }

        private <T> Collection<T> getBeansOfType(Class<T> type) {
            return this.beanFactory.getBeansOfType(type).values();
    }
    
```    
从代码中可以看出，只要定义了Convert,GenericConvert和Formatter接口的实现类的Bean，这些Bean就会自动注册到Spring MVC中。