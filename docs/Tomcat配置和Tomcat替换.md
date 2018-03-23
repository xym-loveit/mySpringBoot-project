下面虽然要说的是Tomcat的配置，但其实对Tomcat,Jetty和Undertow都是通用的。

—-关于Tomcat的所有属性都在org.springframework.boot.autoconfigure.web.ServerProperties配置类中做了定义，我们只需要在application.properties配置属性做配置即可。通用的Servlet容器配置都以”server”作为前缀，而Tomcat特有配置都以”server.tomcat“作为前缀。下面举些常用的例子：

### 1. 配置Servlet容器
```
server.port= #配置程序端口,默认为8080  
server.session-timeout= #用户会话session过期时间,以秒为单位  
server.context-path= #配置访问路径,默认为/  
```

### 2.配置Tomcat
```
server.tomcat.uri-encoding= #配置Tomcat编码，默认为UTF-8  
server.tomcat.compression= #Tomcat是否开启压缩，默认为关闭off  
更为详细的Servlet容器配置以及Tomcat配置，请查看官网文档
```

### 二. 代码配置Tomcat

如果需要通过代码的方式配置servlet容器，则可以注册一个实现EmbeddedServletContainerCustomizer接口的Bean;若想直接配置Tomcat,Jetty,Undertow,则可以直接定义TomcatEmbeddedServletContainerFactory,JettyEmbeddedServletContainerFactory,UndertowEmbeddedServletContainerFactory。

#### 1. 通用配置

##### 1.1 新建类的配置

```
package org.light4j.springBoot.web.tomcat;

import java.util.concurrent.TimeUnit;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.ErrorPage;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class CustomServletContainer implements EmbeddedServletContainerCustomizer {

    @Override
    public void customize(ConfigurableEmbeddedServletContainer container) {
        container.setPort(8888);
        container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/404.html"));
        container.setSessionTimeout(10, TimeUnit.MINUTES);

    }
}
```

##### 1.2 当前配置文件的配置。

若要在当前已有的配置文件内部添加类的Bean的话，则在Spring配置中，注意当前类要声明为static:
```

package org.light4j.springBoot.web.tomcat;

import java.util.concurrent.TimeUnit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.ErrorPage;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class Demo1Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo1Application.class, args);
    }

    @Component
    public static class CustomServletContainer implements EmbeddedServletContainerCustomizer{

        @Override
        public void customize(ConfigurableEmbeddedServletContainer container) {
            container.setPort(8888);//①
            container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/404.html"));//②
            container.setSessionTimeout(10,TimeUnit.MINUTES);//③
        }

    }
}

```

#### 2. 特定配置

下面以Tomcat为例，(Jetty使用JettyEmbeddedServletContainerFactory,Undertow使用UndertowEmbeddedServletContainerFactory)：

```
@Bean
public EmbeddedServletContainerFactory servletContainer() {
    TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();
    factory.setPort(8888);//①
    factory.setSessionTimeout(10, TimeUnit.MINUTES);
    factory.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/404.html"));//②
    return factory;//③
}
```

代码解释：
上面两个例子的代码都实现了这些功能：
① 配置端口号
② 配置错误页面,根据HttpStatus中的错误状态信息,直接转向错误页面,其中404.html放置在src/main/resources/static下即可。
③ 配置Servlet容器用户会话(session)过期时间。

### 二. 替换Tomcat

Spring Boot默认使用Tomcat作为内嵌的Servlet容器，查看spring-boot-starter-web依赖，如下图所示： 

![spring-boot-starter-web默认依赖tomcat][001]

如果要使用Jetty或者Undertow为Servlet容器，只需修改spring-boot-starter-web即可,
#### 1. 替换为Jetty

在pom.xml中，将spring-boot-starter-web的依赖由spring-boot-starter-tomcat替换为spring-boot-starter-Jetty:
```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
    <exclusions>
        <exclusion>
           <groupId>org.springframework.boot</groupId>
           <artifactId>spring-boot-starter-tomcat</artifactId>
        </exclusion>
    </exclusions>
</dependency>

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-jetty</artifactId>
</dependency>

```
此时启动Spring Boot，控制台输出效果如下图所示：

![]

#### 2. 替换为Undertow

在pom.xml中，将spring-boot-starter-web的依赖由spring-boot-starter-tomcat替换为spring-boot-starter-undertow:

```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
    <exclusions>
        <exclusion>
           <groupId>org.springframework.boot</groupId>
           <artifactId>spring-boot-starter-tomcat</artifactId>
        </exclusion>
    </exclusions>
</dependency>

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-undertow</artifactId>
</dependency>

```
此时启动Spring Boot,控制台输出效果如下图所示：
![]





[001]:imgs/spring-boot-starter-web-tomcat.png "spring-boot-starter-web默认依赖了tomcat"

