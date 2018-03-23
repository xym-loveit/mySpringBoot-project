Spring Boot可以允许使用properties文件，yaml文件或者命令行参数作为外部配置。使用properties文件，yaml文件进行配置的例子在之前文章Spring Boot核心(二):Spring Boot的配置文件中已经有过演示，下面专门说命令行参数配置。

Spring Boot可以是基于jar包运行的，使用如下命令打包：
```
mvn package

```
打成jar包的程序可以直接通过下面的命令运行：
```
java -jar xxx.jar

```

可以通过以下命令修改Tomcat端口号：
```
java -jar xxx.jar --server.port=9090

```
修改之后Tomcat将在9090端口启动服务