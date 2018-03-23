想要把spring-boot项目按照平常的web项目一样发布到tomcat容器下需要进行下列几个步骤:
### 一、修改打包形式 


在pom.xml里设置
```
<packaging>war</packaging>

```

### 二、移除嵌入式tomcat插件

在pom.xml里找到spring-boot-starter-web依赖节点,在其中进行如下修改:
```

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
    <!-- 移除嵌入式tomcat插件 -->
    <exclusions>
        <exclusion>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-tomcat</artifactId>
        </exclusion>
    </exclusions>
</dependency>

```

### 三、添加本地调试Tomcat

为了本地调试方便，在pom.xml文件中,dependencies下面添加
```

<dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-tomcat</artifactId>
        <scope>provided</scope>
</dependency>

```

### 四、修改启动类，并重写初始化方法

我们平常用main方法启动的方式，都有一个Application的启动类，代码如下：
```

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

```
我们需要类似于web.xml的配置方式来启动spring上下文，在Application类的同级添加一个SpringBootStartApplication类，其代码如下:

```

/**
 * 修改启动类，继承 SpringBootServletInitializer 并重写 configure 方法
 */
public class SpringBootStartApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        // 注意这里要指向原先用main方法执行的Application启动类
        return builder.sources(Application.class);
    }
}

```

### 五、打包部署

在项目根目录下（即包含pom.xml的目录），在命令行里输入：
```
mvn clean package

```
即可， 等待打包完成，出现[INFO] BUILD SUCCESS即为打包成功。然后把target目录下的war包放到tomcat的webapps目录下，启动tomcat，即可自动解压部署。 最后在浏览器中输入:

http://localhost:[端口号]/[打包项目名]/
发布成功。

### 六、总结

这样,只需要以上5步就可以打包成war包，并且部署到tomcat中了。需要注意的是这样部署的request url需要在端口后加上项目的名字才能正常访问。spring-boot更加强大的一点就是：即便项目是以上配置，依然可以用内嵌的tomcat来调试，启动命令和以前没变，还是：mvn spring-boot:run。如果需要在springboot中加上request前缀，需要在application.properties中添加server.contextPath=/prefix/即可。其中prefix为前缀名。这个前缀会在war包中失效，取而代之的是war包名称，如果war包名称和prefix相同的话，那么调试环境和正式部署环境就是一个request地址了。
注意点:
我测试的时候，使用的相关环境版本如下：
jdk:

jdk1.7.0_71
tomcat:

apache-tomcat-8.5.8
spring boot:

1.4.0.RELEASE
最开始我使用的spring boot版本是1.3.0.RELEASE,部署到tomcat中出现找不到类等各种问题,后来把spring boot版本升级