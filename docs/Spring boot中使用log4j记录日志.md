之前在Spring Boot日志管理 一文中主要介绍了Spring Boot中默认日志工具（logback）的基本配置内容。对于很多习惯使用log4j的开发者，Spring Boot依然可以很好的支持，只是需要做一些小小的配置功能。

### 引入log4j依赖

在创建Spring Boot工程时，我们引入了spring-boot-starter，其中包含了spring-boot-starter-logging，该依赖内容就是Spring Boot默认的日志框架Logback，所以我们在引入log4j之前，需要先排除该包的依赖，再引入log4j的依赖，就像下面这样：
```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter</artifactId>
    <exclusions>
        <exclusion> 
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-logging</artifactId>
        </exclusion>
    </exclusions>
</dependency>

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-log4j</artifactId>
</dependency>

```
### 配置log4j.properties

在引入了log4j依赖之后，只需要在src/main/resources目录下加入log4j.properties配置文件，就可以开始对应用的日志进行配置使用。

#### 控制台输出
通过如下配置，设定root日志的输出级别为INFO，appender为控制台输出stdout
```
# LOG4J配置
log4j.rootCategory=INFO, stdout

# 控制台输出
log4j.appender.stdout=org.apache.log4j.ConsoleAppender
log4j.appender.stdout.layout=org.apache.log4j.PatternLayout
log4j.appender.stdout.layout.ConversionPattern=%d{yyyy-MM-dd HH:mm:ss,SSS} %5p %c{1}:%L - %m%n

```
#### 输出到文件

在开发环境，我们只是输出到控制台没有问题，但是到了生产或测试环境，或许持久化日志内容，方便追溯问题原因。可以通过添加如下的appender内容，按天输出到不同的文件中去，同时还需要为log4j.rootCategory添加名为file的appender，这样root日志就可以输出到logs/all.log文件中了。
```
#
log4j.rootCategory=INFO, stdout, file

# root日志输出
log4j.appender.file=org.apache.log4j.DailyRollingFileAppender
log4j.appender.file.file=logs/all.log
log4j.appender.file.DatePattern='.'yyyy-MM-dd
log4j.appender.file.layout=org.apache.log4j.PatternLayout
log4j.appender.file.layout.ConversionPattern=%d{yyyy-MM-dd HH:mm:ss,SSS} %5p %c{1}:%L - %m%n

```
#### 分类输出

当我们日志量较多的时候，查找问题会非常困难，常用的手段就是对日志进行分类，比如：

可以按不同package进行输出。通过定义输出到logs/my.log的appender，并对com.didispace包下的日志级别设定为DEBUG级别、appender设置为输出到logs/my.log的名为didifile的appender。
```
# com.didispace包下的日志配置
log4j.category.com.didispace=DEBUG, didifile

# com.didispace下的日志输出
log4j.appender.didifile=org.apache.log4j.DailyRollingFileAppender
log4j.appender.didifile.file=logs/my.log
log4j.appender.didifile.DatePattern='.'yyyy-MM-dd
log4j.appender.didifile.layout=org.apache.log4j.PatternLayout
log4j.appender.didifile.layout.ConversionPattern=%d{yyyy-MM-dd HH:mm:ss,SSS} %5p %c{1}:%L ---- %m%n

```
可以对不同级别进行分类，比如对ERROR级别输出到特定的日志文件中，具体配置可以如下。
```
log4j.logger.error=errorfile
# error日志输出
log4j.appender.errorfile=org.apache.log4j.DailyRollingFileAppender
log4j.appender.errorfile.file=logs/error.log
log4j.appender.errorfile.DatePattern='.'yyyy-MM-dd
log4j.appender.errorfile.Threshold = ERROR
log4j.appender.errorfile.layout=org.apache.log4j.PatternLayout
log4j.appender.errorfile.layout.ConversionPattern=%d{yyyy-MM-dd HH:mm:ss,SSS} %5p %c{1}:%L - %m%n

```
本文主要介绍如何在spring boot中引入log4j，以及一些基础用法，对于更多log4j的用法，还请参考log4j[官方网站](http://logging.apache.org/log4j/1.2/)
