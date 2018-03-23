Spring Boot通过使用starter pom使得我们不需要关注各种依赖库的处理，不需要具体的配置信息，由Spring Boot自动通过classpath路径下的类发现需要的Bean，并织入bean。

Spring Boot为我们提供了简化企业级开发绝大多数场景的starter pom，只要使用了应用场景所需要的starter pom，相关的技术配置将会消除，就可以得到Spring Boot为我们提供的自动配置的Bean。

### 一. 官方starter pom

官方提供的starter pom特别多，详细可参考[官网文档](https://docs.spring.io/spring-boot/docs/current-SNAPSHOT/reference/htmlsingle/#using-boot-starter)。下面列出部分供参考：

名称|描述
---|:---
spring-boot-starter|Spring Boot核心的starter，包含自动配置，日志，yaml配置文件等的支持
spring-boot-starter-actuator|准生产应用，用来监控和管理应用
spring-boot-starter-remote-shell|提供基于ssh协议的监控和管理
spring-boot-starter-amqp|使用spring-rabbit来支持AMQP
spring-boot-starter-aop|使用spring-aop和AspectJ支持面向切面编程
spring-boot-starter-batch|提供对Spring Batch的支持
spring-boot-starter-cache|提供对Spring Cache的支持
spring-boot-starter-cloud-connectors|对云平台(Cloud Foundry，Heroku)提供的服务提供简化的连接方式
spring-boot-starter-data-elasticsearch|通过spring-data-elasticsearch对Elasticsearcht提供支持
spring-boot-starter-data-gemfire|通过spring-data-gemfire对GemFire提供支持
spring-boot-starter-data-jpa|对JPA的支持，包含spring-data-jpa，spring-orm和Hibernate
spring-boot-starter-data-mongodb|通过spring-data-mongodb对MongoDB提供支持
spring-boot-starter-data-rest|通过spring-data-rest-webmvc将Spring Data respository暴露为Rest的服务
spring-boot-starter-data-solr|通过spring-data-rest-solr对Apache Solr数据检索平台的支持。
spring-boot-starter-freemarker|对FreeMarker模板引擎提供支持
spring-boot-starter-groovy-templates|对Groovy模板引擎提供支持
spring-boot-starter-hateoas|通过spring-hateoas对基于HATEOAS的REST形式的网络服务的支持
spring-boot-starter-hornetq|通过Hornetq对JMS的支持
spring-boot-starter-integration|对系统集成框架spring-integration的支持
spring-boot-starter-jdbc|对JDBC数据库的支持
spring-boot-starter-jersey|对Jersery REST形式的网络服务的支持
spring-boot-starter-jta-atomikos|通过Atomikos对分布式事务的支持
spring-boot-starter-jta-bitronix|通过Bitronix对分布式事务的支持
spring-boot-starter-mail|对javax.mail的支持
spring-boot-starter-mobile|对spring-mobile的支持
spring-boot-starter-mustache|对Mustache模板引擎的支持
spring-boot-starter-redis|对键值对内存数据库Redis的支持，包含spring-redis
spring-boot-starter-security|对spring-security的支持
spring-boot-starter-social-facebook|通过spring-social-facebook对FaceBook的支持
spring-boot-starter-social-linkedin|通过spring-social-linkedin对LinkedIn的支持
spring-boot-starter-social-twitter|通过spring-social-twitter对Twitter的支持
spring-boot-starter-test|对常用的测试框架Junit，Hamcrest和Mockito的支持，包含spring-test模块
spring-boot-starter-thymeleaf|对Thymeleaf模板引擎的支持，包含于Spring整合的配置
spring-boot-starter-velocity|对Velocity模板引擎的支持
spring-boot-starter-web|对Web项目开发的支持，包含Tomcat和spring-webmvc
spring-boot-starter-Tomcat|Spring Boot默认的Servlet容器Tomcat
spring-boot-starter-Jetty|使用Jetty作为Servlet容器替换Tomcat
spring-boot-starter-undertow|使用Undertow作为Servlet容器替换Tomcat
spring-boot-starter-logging|Spring Boot默认的日志框架Logback
spring-boot-starter-log4j|支持使用log4J日志框架
spring-boot-starter-websocket|对WebSocket开发的支持
spring-boot-starter-ws|对Spring Web Services的支持

### 二. 第三方starter pom

除了官方starter pom外，还有第三方为Spring Boot所写的starter pom，如下图所示：

名称|地址
---|:---
Handlebars|https://github.com/allegro/handlebars-spring-boot-starter
Vaadin|https://github.com/vaadin/spring/tree/master/vaadin-spring-boot-starter
Apache Camel|https://github.com/apache/camel/tree/master/components/camel-spring-boot
WRO4J|https://github.com/sbuettner/spring-boot-autoconfigure-wro4j
Spring Batch(高级用法)|https://github.com/codecentric/spring-boot-starter-batch-web
HDIV|https://github.com/hdiv/spring-boot-starter-hdiv
Jade Templates (Jadw4j)|https://github.com/domix/spring-boot-starter-jade4j
Activiti|https://github.com/Activiti/Activiti/tree/master/modules/activiti-spring-boot/spring-boot-starters

如果有需要我们也可以编写自己的starter pom
