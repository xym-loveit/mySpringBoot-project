
### 一. 最佳实践：
spring本身推崇约定优于配置的开发方式，Spring Boot框架并没有对工程结构有什么特别的要求，但是如果我们按照最佳实践的工程结构来进行开发，可以帮助我们减少项目中遇见的坑，尤其是Spring包扫描机制的存在，如果您使用最佳实践的工程结构，可以免去不少特殊的配置工作。

### 二. 实践示例：
#### 1. root package结构：
```
org.light4j.springboot.sample
```

#### 2. 应用主类Application.java
Application.java置于root package下，通常我们会在应用主类中做一些框架配置扫描等配置，我们放在root package下可以帮助程序减少手工配置来加载到我们希望被Spring加载的内容
#### 3. 数据访问层(dao)
数据访问层(dao)与实体(po)的包如下:
```
org.light4j.springboot.sample.dao

```
#### 4. 数据库访问实体(po)
数据库访问实体(po)的包如下:
```
org.light4j.springboot.sample.dao.po
```
#### 5. 逻辑层(Service)
逻辑层(Service)的包如下:
```
org.light4j.springboot.sample.service

```
#### 6. Web层(web)
Web层(web)的包如下:
```
org.light4j.springboot.sample.web

```
7. Common层(common)
Common层(common)的包如下:
```
org.light4j.springboot.sample.common

```
6.资源文件和静态文件
配置文件application.properties放置到src/main/resources下，我司采用的是mybatis框架进行开发,所以mapper文件放置在src/main/resources下面新建的文件夹mybatisMapper里(不用.xml文件的可以忽略),页面文件放置在src/main/resources下面新建的文件夹templates里，静态文件放置在src/main/resources下面新建的文件夹static里，当然还可以进一步指定子文件夹，看自己的细分粒度

### 三.参见工程结构

![推荐工程结构][001]


[001]:../springBoot-quickStart/src/main/resources/static/img/SpringBoot推荐工程结构.png "推荐工程结构"