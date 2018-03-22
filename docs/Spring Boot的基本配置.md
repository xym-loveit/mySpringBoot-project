### 一. 配置不继承SpringBoot父依赖项目
在真实的企业级项目中，一个大的项目会由多个子模块组成，每个模块是一个小的项目，那么每个模块都有自己的父项目，这个时候就不能再依赖spring提供的父项目了，这时候怎么办呢?spring boot已经考虑到了这种可能性，下面就来看看怎么解决的。
单一模块的时候，我们会看到我们的Spring Boot项目有个parent依赖，如下所示：
```
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>1.4.5.RELEASE</version>
    <relativePath />
</parent>

```
在真实的企业级项目中，这部分内容被我们自己的父模块占用了，比如变成了如下： 
```
<parent>
    <groupId>org.light4j</groupId>
    <artifactId>springBoot-basic</artifactId>
    <version>0.0.1-SNAPSHOT</version>
</parent>

```
这个时候，只需要加如下依赖即可解决原来依赖Spring Boot的parent的问题：
```
<dependencyManagement>
    <dependencies>
        <dependency>
            <!-- Import dependency management from Spring Boot -->
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-dependencies</artifactId>
            <version>1.4.5.RELEASE</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>
    </dependencies>
/dependencyManagement>

```

别的部分不需要变动，后面的内容都按照这种方式来进行。

### 二. 入口类和@SpringBootApplication
Spring Boot通常有一个名为*Application的入口类，入口类里面有一个main方法，这个main方法其实就是一个标准的Java应用的入口。在main方法中使用SpringApplication.run(HelloApplication.class, args)，启动Spring Boot应用项目。

@SpringBootApplication是Spring Boot的核心注解，它是一个组合注解,对组合注解不了解的朋友可以看前面的文章Spring4.x高级话题(五):组合注解与元注解，SpringBootApplication源码如下：

```
@Target({java.lang.annotation.ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Configuration
@EnableAutoConfiguration
@ComponentScan
public @interface SpringBootApplication
{
  public abstract Class<?>[] exclude();

  public abstract String[] excludeName();
}
```

@SpringBootApplication注解主要组合了@Configuration，@EnableAutoConfiguration，@ComponentScan；若不使用@SpringBootApplication注解，则可以在入口类上直接使用@Configuration，@EnableAutoConfiguration，@ComponentScan三个注解的效果是一样的。
其中@EnableAutoConfiguration让Spring Boot根据类路径中的jar包依赖为当前项目进行自动配置。

例如，添加了spring-boot-starter-web依赖，会自动添加Tomcat和Spring MVC的依赖，那么Spring Boot会对Tomcat和Spring MVC进行自动配置。

又如，添加了spring-boot-starter-jpa依赖,Spring Boot会自动进行JPA相关的配置。

Spring Boot会自动扫描@SpringBootApplication所在类的同级包(如org.light4j.springboot.config)以及下级包里面的Bean(若为JPA项目还可以扫描标注@Entity的实体类)。建议入口类放置在groupId+arctifactID组合的包名下。

### 三. 关闭特定的自动配置
通过上面的@SpringBootApplication的源码可以看出，关闭特定的自动配置应该使用@SpringBootApplication注解的exclude参数，比如要关闭Spring Boot对数据源的自动配置，则可以这样使用，例如：
```
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})

```
### 四. 定制Banner
#### 1. 修改Banner
在Spring Boot启动的时候会有一个默认启动方案，如下图所示：

![springBoot-Banner][001]
如果想把这个图案修改成自己的，步骤如下所示：

(1). 在src/main/resources下新建一个banner.txt。
(2). 通过http://patorjk.com/software/taag网站生成字符，如敲入的为"LONGJIAZUO",将网站生成的字符复制到banner.txt中。
(3). 这时再启动程序，图案将变为如下图所示：

![springBoot-Banner-update][002]


### 五. 关闭banner

#### 1. 入口类main方法里的内容修改为：
```
SpringApplication application = new SpringApplication(HelloApplication.class);
application.setBannerMode(Banner.Mode.OFF);
application.run(args);

```

#### 2. 或者使用fluent API修改为：
```
new SpringApplicationBuilder(HelloApplication.class).bannerMode(Banner.Mode.OFF).run(args);

```







[001]:../springBoot-quickStart/src/main/resources/static/img/springBoot-banner.png
[002]:../springBoot-quickStart/src/main/resources/static/img/my-banner.png