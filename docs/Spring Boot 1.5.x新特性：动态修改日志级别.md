前天Spring Boot 1.5终于迎来了第一个RELEASE版本：1.5.0，但是由于一个编译依赖问题在第二天直接连击到了1.5.1。该版本的发布包含了超过320位贡献者的奉献、10000多次的代码提交。

每次Spring Boot版本更新所带来的新特性都是我们每个用户特别关注的。虽然其中不少特性可能对于大部分用户来说还不一定适用，但是作为基础知识的储备还是有一定的必要性。对于1.5.x版本的新特性列表读者可以直接查看官方博文：《Spring Boot 1.5.1 released》来了解它们，本文不做这些概要性的介绍。在后续的一段时间内，本博客将会陆续介绍一些笔者关心且将会使用的关于Spring Boot 1.5.x中的一些新特性。

### loggers端点

本文我们就来看看Spring Boot 1.5.x中引入的一个新的控制端点：/loggers，该端点将为我们提供动态修改Spring Boot应用日志级别的强大功能。该功能的使用非常简单，它依然延续了Spring Boot自动化配置的实现，所以只需要在引入了spring-boot-starter-actuator依赖的条件下就会自动开启该端点的功能（更多关于spring-boot-starter-actuator模块的详细介绍可见：《Spring Boot Actuator监控端点小结》一文）。

下面，我们不妨通过一个实际示例来看看如何使用该功能：

* 构建一个基础的Spring Boot应用。如果您对于如何构建还不熟悉，可以参考《使用Intellij中的Spring Initializr来快速构建Spring Boot/Cloud工程》一文。

* 在pom.xml引入如下依赖（如果使用Intellij中的Spring Initializr的话直接在提示框中选下web和actuator模块即可）。
```
<parent>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-parent</artifactId>
	<version>1.5.1.RELEASE</version>
	<relativePath/> <!-- lookup parent from repository -->
</parent>

<dependencies>
	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-actuator</artifactId>
	</dependency>
	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-web</artifactId>
	</dependency>
</dependencies>

```
* 在应用主类中添加一个接口用来测试日志级别的变化，比如下面的实现：

```java
@RestController
@SpringBootApplication
public class DemoApplication {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String testLogLevel() {
		logger.debug("Logger Level ：DEBUG");
		logger.info("Logger Level ：INFO");
		logger.error("Logger Level ：ERROR");
		return "";
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
  
}

```
* 为了后续的试验顺利，在application.properties中增加一个配置，来关闭安全认证校验。
```
management.security.enabled=false

```
不然在访问/loggers端点的时候，会报如下错误：

```

{
  "timestamp": 1485873161065,
  "status": 401,
  "error": "Unauthorized",
  "message": "Full authentication is required to access this resource.",
  "path": "/loggers/com.didispace"
}

```
#### 测试验证

在完成了上面的构建之后，我们启动示例应用，并访问/test端点，我们可以在控制台中看到如下输出：
```
2017-01-31 22:34:57.123  INFO 16372 --- [nio-8000-exec-1] ication$$EnhancerBySpringCGLIB$$d2a0b1e2 : Logger Level ：INFO
2017-01-31 22:34:57.124 ERROR 16372 --- [nio-8000-exec-1] ication$$EnhancerBySpringCGLIB$$d2a0b1e2 : Logger Level ：ERROR

```
由于默认的日志级别为INFO，所以并没有输出DEBUG级别的内容。下面我们可以尝试通过/logger端点来将日志级别调整为DEBUG，比如，发送POST请求到/loggers/com.didispace端点，其中请求体Body内容为：

```
{
    "configuredLevel": "DEBUG"
}

```
重新访问/test端点，我们将在控制台中看到如下输出，在/test端点中定义的DEBUG日志内容被打印了出来：
```
2017-01-31 22:37:35.252 DEBUG 16372 --- [nio-8000-exec-5] ication$$EnhancerBySpringCGLIB$$d2a0b1e2 : Logger Level ：DEBUG
2017-01-31 22:37:35.252  INFO 16372 --- [nio-8000-exec-5] ication$$EnhancerBySpringCGLIB$$d2a0b1e2 : Logger Level ：INFO
2017-01-31 22:37:35.252 ERROR 16372 --- [nio-8000-exec-5] ication$$EnhancerBySpringCGLIB$$d2a0b1e2 : Logger Level ：ERROR

```
可以看到，到这里为止，我们并没有重启过Spring Boot应用，而只是简单的通过调用/loggers端点就能控制日志级别的更新。除了POST请求之外，我们也可以通过GET请求来查看当前的日志级别设置，比如：发送GET请求到/loggers/com.didispace端点，我们将获得对于com.didispace包的日志级别设置：
```
{
  "configuredLevel": "DEBUG",
  "effectiveLevel": "DEBUG"
}

```
我们也可以不限定条件，直接通过GET请求访问/loggers来获取所有的日志级别设置，这里就不列举具体返回，读者可以自行尝试。