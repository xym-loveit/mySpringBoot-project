### 一. 点睛 

Spring Boot的全局配置文件的作用是对一些默认配置的配置值进行修改。Spring Boot使用一个全局的配置文件application.properties或application.yml进行全局配置，放置在src/main/resources目录或者类路径的/config下。

Spring Boot不仅支持常规的properties配置文件，还支持yaml语言的配置文件。yaml是以数据为中心的语言，在配置数据的时候具有面向对象的特征。

### 二. 简单示例

将Tomcat的默认端口号修改为9090，并将默认的访问路径”/”修改为”/springboot_configFile“，可以在application.properties中添加：

server.port=9090
server.context-path=/springboot_configFile
或者在application.yml中添加：

server:
  port:9090
  contextPath:/springboot_configFile
从上面的配置可以看出，在Spring Boot中，context-path,contextPath或者CONTEXT_PATH形式其实是相通的。并且，yaml的配置更简洁清晰，更多Spring Boot常用配置请参考[官网文档](https://docs.spring.io/spring-boot/docs/current-SNAPSHOT/reference/htmlsingle/#appendix)

启动项目，可以看到启动端口是9090，如下图所示：

![server-port-log][001]

访问项目的路径变成了：http://localhost:9090/springboot_configFile/，运行效果如下所示：

![server-contextPath][002]




[001]:../springBoot-quickStart/src/main/resources/static/img/server-port.png "启动端口"
[002]:../springBoot-quickStart/src/main/resources/static/img/server-contextPath.png "访问上下文"

