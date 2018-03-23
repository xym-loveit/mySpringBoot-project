### 一. 什么是Spring Boot
随着动态语言的流行(Ruby,Groovy,Scala,Node.js)，Java的开发显得格外的笨重：繁多的配置，低下的开发效率，复杂的部署流程以及第三方技术集成难度大。

在上述环境下，Spring Boot应运而生。它使用”习惯优于配置”(项目中存在大量的配置，此外还内置一个习惯性的配置，让你无须进行手动配置)的理念让你的项目快速运行起来。使用Spring Boot很容易创建一个独立运行(运行jar,内嵌Servlet容器)，准生产级别的Spring框架的项目，使用Spring Boot你可以不用或者只需要很少的Spring配置。

### 二. Spring Boot核心功能
#### 1. 独立运行的Spring项目
Spring Boot可以以jar包的形式独立运行，运行一个Spring Boot项目只需通过java -jar xx.jar来运行。

#### 2. 内嵌Servlet容器
Spring Boot可选择内嵌的Tomcat，Jetty或者Undertow，这样我们无须以war包形式部署项目。

#### 3. 提供starter简化Maven配置
Spring提供了一系列的starter pom来简化Maven的依赖加载，例如，当你使用了spring-boot-starter-web时时，会自动加入如下图所示的依赖包。
![spring-boot-starter-web依赖包][001]

#### 4. 自动配置Spring
Spring Boot会根据在类路径中的jar包，类，为jar包里的类自动配置Bean，这样会极大地减少我们要使用的配置。当然，SpringBoot只是考虑了大多数的开发场景，并不是所有的场景，若在实际开发中我们需要自动配置Bean，而Spring Boot没有提供支持，则可以自定义配置，后面会有介绍。

#### 5. 准生产的应用监控
Spring Boot提供基于http,ssh,telnet对运行的项目进行监控

#### 6. 无代码生成和xml配置
Spring Boot神奇的不是借助于代码生成来实现的，而是通过条件注解来实现的，这是Spring4.x提供的新特性，在前面的文章Spring4.x高级话题(四):条件注解@Conditional中有过简单的演示。

Spring Boot提倡使用Java配置和注解配置组合，而Spring Boot不需要任何xml配置即可 实现Spring的所有配置。

### 三. Spring Boot的优缺点
#### 1. 优点：
- (1) 快速构建项目；
- (2) 对主流开发框架的无配置集成；
- (3) 项目可独立运行，无须外部依赖Servlet容器；
- (4) 提供运行时的应用监控；
- (5) 极大的提高了开发，部署效率；
- (6) 与云计算的天然集成。


[001]:../springBoot-quickStart/src/main/resources/static/img/spring-boot-starter-web依赖包. "spring-boot-starter-web依赖包"