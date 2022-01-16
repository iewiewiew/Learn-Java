[TOC]

<h1 align="center">Java教程</h1>

> By：weimenghua
> Date：2024.12.01
> Description：


**参考资料**
1. [SpringBoot-Learning](https://gitee.com/didispace/SpringBoot-Learning)
2. [spring-boot-demoDto](https://gitee.com/roncoocom/spring-boot-demoDto)
3. [iocoder](https://www.iocoder.cn/coke/)
4. [SpringBoot-Labs](https://github.com/YunaiV/SpringBoot-Labs)
5. [SpringBootLearning](https://github.com/gf-huanchupk/SpringBootLearning)
6. [springboot-bucket](https://gitee.com/yidao620/springboot-bucket)
7. [renren-security](https://gitee.com/renrenio/renren-security)
8. [renren-ui](https://gitee.com/renrenio/renren-ui)
9. [smart-admin](https://gitee.com/lab1024/smart-admin)

## 1. JavaWeb 教程

### 1.1 注解

#### 1 启动类注解

- **@SpringBootApplication**：等价于 @Configuration+@EnableAutoConfiguration+@ComponentScan。
- **@EnableAutoConfiguration**：开启自动配置功能，自动根据导入的依赖来自动配置项目。
- **@ComponentScan**：该注解标识的类，会被 Spring 自动扫描并且装入bean[容器](https://cloud.tencent.com/product/tke?from=10680)。
- **@Configuration**：定义配置类，被注解的类内部包含有一个或多个被 @Bean 注解的方法。

#### 2 配置注解

- **@Import**：用来导入其他配置类。
- **@ImportResource**：用来加载xml配置文件。
- **@Service**：一般用于修饰 service 层的组件。
- **@Repository**：使用该注解可以确保 dao 或者 repositories 提供异常转译，这个注解修饰的类会被ComponetScan发现并配置，同时也不需要为它们提供XML配置项。
- **@Value**：注入properties/yml 配置的属性的值，具体用法如下：@Value("${tool.calculate.digits}")  private String digits;
- **@Bean**：标注在方法上，将方法的返回对象交由 Spring 处理。
- **@Component**：泛指组件，当组件不好归类的时候，我们可以使用这个注解进行标注。
- **@Slf4j**：使用SLF4J日志类库，无需创建日志记录器。
- **@Scope**：
- **@EnableAsync**： 是一个 Spring Boot 中用于启动异步方法调用的注解。使用 @EnableAsync 注解时，需要将其放置在一个配置类上，并且在配置类中通过 @Bean 方法创建一个线程池。

#### 3 元注解

- **@Documented**：表明这个注解应该被 javadoc工具记录。默认情况下，javadoc是不包括注解的，但如果声明注解时指定了 @Documented，则它会被 javadoc 之类的工具处理，所以注解类型信息也会被包括在生成的文档中，是一个标记注解，没有成员。
- **@Target**：用于定义注解的使用位置，如果没有该项，表示注解可以用于任何地方。
- **@Retention**：用于指明修饰的注解的生存周期，即会保留到哪个阶段。
- **@Inherited**：用于标注一个父类的注解是否可以被子类继承。

#### 4 AOP相关注解

AOP（Aspect Oriented Programming）意为“面向切面编程”，旨在分离关注点，达到一种可配置的、可插拔的程序结构。

- **@Aspect**：用来描述一个切面类，定义切面类的时候需要打上这个注解。
- **@Pointcut**：用来定义一个切面（切入点），即上文中所关注的某件事情的入口。切入点决定了连接点关注的内容，使得我们可以控制通知什么时候执行。
- **@Before**：指定的方法在切面切入目标方法之前执行，可以做一些 Log 处理，也可以做一些信息的统计。
- **@After**：指定的方法在切面切入目标方法之后执行，也可以做一些完成某方法之后的 Log 处理。
- **@AfterReturning**：用来捕获切入方法执行完之后的返回值，对返回值进行业务逻辑上的增强处理。
- **@AfterThrowing**：当被切方法执行过程中抛出异常时，会进入 @AfterThrowing 注解的方法中执行，在该方法中可以做一些异常的处理逻辑。

#### 5 异常处理相关注解

- **@RestControllerAdvice**：
- **@ExceptionHandler**：

#### 6 Bean注入相关注解

- **@Autowired**：按类型（byType）自动注入依赖的Bean，可以对类成员变量、方法及构造函数进行标注。可以添加（required=false）属性，规避无法匹配相应Bean的异常。
- **@Qualifier**：当存在多个同一类型的Bean时，可以用@Qualifier(“name”)配合@Autowired来指定要注入的Bean。
- **@Resource(name=”name”,type=”type”)**：功能与@Autowired类似，没有括号内内容的话，默认使用byName方式匹配。
- **@Inject**：等价于默认的@Autowired，只是没有required属性。

#### 7 MVC项目相关注解

- **@Controller**：用于定义控制器类，在Spring项目中由控制器负责将用户发来的URL请求转发到对应的服务接口（service层），一般这个注解在类中，通常方法需要配合注解@RequestMapping。
- **@ResponseBody**：直接返回json数据。
- **@RestController**： SpringBoot 新增的一个注解，返回JSON格式的数据，可以看作是 @Controller 和 @ResponseBody 的结合体。
- **@RequestMapping**：用来处理请求地址映射的注解，它可以用于类上，也可以用于方法上。
- **@PathVariable**:要用来获取Restful风格的url("/student/{id}")的参数。
- **@RequestParam**：也是获取请求参数的，和@PathVariable不同之处在于，它处理的url格式为http://localhost:8080/student?id=1。
- **@RequestBody**：用于接收前端传来的实体，接收参数也是对应的实体。

#### 8 数据层相关注解

- **@Transactional**：使用这个注解的类或者方法表示该类里面的所有方法或者这个方法的事务由spring处理，来保证事务的原子性，即是方法里面对[数据库](https://cloud.tencent.com/solution/database?from=10680)操作，如果失败则spring负责回滚操作，成功则提交操作。
- **@Mapper**：注解在dao层接口上，最终 Mybatis 会有一个拦截器，会自动的把 @Mapper 注解的接口生成动态代理类。
- **@MapperScan**：注解在启动类上，配置一个或多个包路径，自动的扫描这些包路径下的类，自动的为它们生成代理类，可以避免为每个dao层接口注解@Mapper。
- **@Select**：注解在dao层方法上，执行一条查询语句。
- **@Insert**：注解在dao层方法上，执行一条插入语句。
- **@Update**：注解在dao层方法上，执行一条更新语句。
- **@Delete**：注解在dao层方法上，执行一条删除语句。

#### 9 实体层相关注解

- **@Setter**：注解在属性上，为属性提供 set 方法。
- **@Getter**：注解在属性上，为属性提供 get 方法。
- **@Data**：注解在类上，提供类所有属性的 get 和 set 方法，此外还提供了equals、canEqual、hashCode、toString 方法。
- **@Builder**：
- **@AllArgsConstructor**：注解在类上，为类提供一个全参的构造方法。
- **@NoArgsConstructor**：注解在类上，为类提供一个无参的构造方法。
- **@Region**：
- **@NonNull**：注解在属性上，该注解修饰的属性不能为 null。
- **@val**：注解在属性上，该注解修饰的属性被设置为 final 类型。
- **@toString**：生成toString方法，默认情况下，会输出类名、所有属性，属性会按照顺序输出，以逗号分割。

#### 10 其它

- 注解（Annotation）是java提供的一种元程序中 元素关联任何信息和任何元数据（metadata）的途径和方法。

### 1.2 参数校验
参数绑定：在 Controller 使用方法参数接收值，就是把 web 端的值给接收到 Controller 中处理，这个过程就叫做参数绑定。
在controller层做参数校验

1. POST、PUT 请求一般会使用 RequestBody 传递参数，这种情况下，后端使用 DTO 对象进行接收。只要给 DTO 对象加上@Validated 注解就能实现自动参数校验。
2. GET 请求一般会使用 RequestParam/PathVariable传参。如果参数比较多(比如超过 6 个)，还是推荐使用 DTO 对象接收。否则，推荐将一个个参数平铺到方法入参中。  在这种情况下，必须在 Controller 类上标注 @Validated 注解，并在入参上声明约束注解(如@Min 等)。如果校验失败，会抛出 ConstraintViolationException 异常。

#### **全局校验规则总结**

| 注解        | 用途                                                       | 适用类型                               |
| ----------- | ---------------------------------------------------------- | -------------------------------------- |
| `@NotNull`  | 校验字段不能为 `null`                                      | 所有类型                               |
| `@NotEmpty` | 校验字段不能为 `null` 且不能为空字符串（或空集合、空数组） | `String`、`Collection`、`Map`、`Array` |
| `@NotBlank` | 校验字段不能为 `null` 且不能是空字符串或仅包含空格         | `String`                               |
| `@Size`     | 校验字段的长度或大小是否在指定范围内                       | `String`、`Collection`、`Map`、`Array` |
| `@Min`      | 校验字段的值是否大于等于指定的最小值                       | `Integer`、`Long`、`Double` 等数字类型 |
| `@Max`      | 校验字段的值是否小于等于指定的最大值                       | `Integer`、`Long`、`Double` 等数字类型 |
| `@Pattern`  | 校验字段是否符合指定的正则表达式                           | `String`                               |

### 1.3 其它

1. 控制台打印 SQL
   在 application.yml 添加 logging 配置，com.wmh.dao 是 dao 层包路径

```
logging:
  level:
    com.wmh.dao: debug
```

2. 踩坑
   启动时候一直卡在“信息: Initializing Spring root WebApplicationContext“
   原因是druid修改成spring-boot的pom了, 使用下面这个才是正确的

```
<dependency>
    <groupId>com.alibaba</groupId>
    <artifactId>druid</artifactId>
    <version>1.0.15</version>
</dependency>
```

3. 控制台打印请求响应报文

```
<!--引入lombok依赖-->
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
</dependency>

<!--引入AOP依赖-->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-aop</artifactId>
</dependency>
```
添加WebLogAspect.java

4、单元测试
单元测试的包路径需要和被测试的类包路径一致。  
单元测试类和启动单元测试类SpringBootDemoApplicationTests需在同一个根目录下。

5、代码混淆
本地加密：java -jar classfinal-fatjar.jar -file yourproject.jar -libjars a.jar,b.jar -packages com.yourpackage,com.yourpackage2 -exclude com.yourpackage.Main -pwd 123456 -Y
启动加密包： java -javaagent:Java-Web-1.0-SNAPSHOT-encrypted.jar='-pwd 123' -jar Java-Web-1.0-SNAPSHOT-encrypted.jar
启动正常包：java -jar Java-Web-1.0-SNAPSHOT.jar

6、Json转实体类

安装GsonFomatPlus插件，新建一个class，在类内右键选择Generate > GsonFormatPlus，填写json，点击确定即可。

### 1.4 远程Debug

1、Edit Configurations > 【+】 > Remote JVM Debug

注：远程Debug端口和应用端口不是同一个端口

![](../docs/img/IDEA-Debug-01.png)

2、启动应用

```
直接启动应用
java -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=8899 -jar Java-Web-1.0-SNAPSHOT.jar

后台启动应用
nohup java -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=8899 -jar Java-Web-1.0-SNAPSHOT.jar > output.log 2>&1 &

传参启动应用
java -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=8899 \ 
-Dapollo.configService=http://127.0.0.1:8080 \
-jar Java-Web-1.0-SNAPSHOT.jar

启动日志：Listening for transport dt_socket at address: 8899
```

3、远程调试

控制台日志：Connected to the target VM, address: '127.0.0.1:8899', transport: 'socket'

打断点，调用接口后即进入调试模式

![](../docs/img/IDEA-Debug-02.png)

### 1.5 热部署 Spring Loaded（注：未实践成功）

[Spring Loaded下载地址](https://github.com/spring-projects/spring-loaded/tags)

1、添加依赖

```
<plugin>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-maven-plugin</artifactId>
    <dependencies>
         <dependency>
             <groupId>org.springframework</groupId>
             <artifactId>springloaded</artifactId>
             <version>1.2.6.RELEASE</version>
        </dependency>
    </dependencies>
</plugin>
```

2、运行

![](../docs/img/springloaded.png)

### 1.6 Spring Boot 配置加载顺序

1、properties文件
2、YAML文件
3、系统环境变量
4、命令行参数

### 1.7 代码规范

**参考资料**

[Java规范 V2.0.md](https://github.com/1024-lab/smart-admin/blob/master/%E4%BB%A3%E7%A0%81%E8%A7%84%E8%8C%83/Java%E8%A7%84%E8%8C%83%20V2.0.md)



##  2. JavaWeb 知识

###  Spring
参考资料：[三歪红着眼睛总结了Spring知识点](https://mp.weixin.qq.com/s/yzAqBV-CEWZzej8ywLilyQ)
Spring 核心概念IOC(控制反转)、DI(依赖注入)、AOP(面向切面编程)。
Spring IOC 解决的是对象管理和对象依赖的问题。本来我们的对象都是new出来的，而我们如果使用Spring 则把对象交给「IOC容器」来管理。  
「IOC容器」是什么？我们可以理解为是一个「工厂」，我们把对象都交由这个「工厂」来管理，包括对象的创建和对象之间的依赖关系等等。等我们要用到对象的时候，就从这个「工厂」里边取出来。  
「控制反转」指的就是：本来是「由我们自己」new出来的对象，现在交给了IOC容器。把这个对象的「控制权」给「他方」了。「控制反转」更多的是一种思想或者说是设计模式，把原有由自己掌控的事交给「别人」来处理。  
「依赖注入」更多指的是「控制反转」这个思想的实现方式：对象无需自行创建或管理它们的依赖关系，依赖关系将被「自动注入」到需要它们的对象当中去。  
最简单理解「依赖注入」和「控制反转」：本来我们的对象都是「由我们自己」new出来的，现在我们把这个对象的创建权限和对象之间的依赖关系交由「IOC容器」来管理。
Spring AOP 解决的是 非业务代码抽取的问题。Spring AOP主要做的事情就是：「把重复的代码抽取，在运行的时候往业务方法上动态植入“切面类代码”」

### SpringCloud
搭建nacos
nacos下载：https://github.com/alibaba/nacos/releases
下载完成之后，解压。根据不同平台，执行不同命令，启动单机版Nacos服务：
Linux/Unix/Mac：sh startup.sh -m standalone
Windows：在cmd执行：startup.cmd -m standalone (D:\software\nacos\bin\startup.cmd -m standalone)
访问：http://127.0.0.1:8848/nacos/，账号密码：nacos/nacos
踩坑：使用低版本的，高版本可能存在一些坑
验证：http://127.0.0.1:8001/hello?name=demoDto

### JPA
spring.jpa.properties.hibernate.hbm2ddl.auto是hibernate的配置属性，其主要作用是：自动创建、更新、验证数据库表结构。该参数的几种配置如下：
create：每次加载hibernate时都会删除上一次的生成的表，然后根据你的model类再重新来生成新表，哪怕两次没有任何改变也要这样执行，这就是导致数据库表数据丢失的一个重要原因。
create-drop：每次加载hibernate时根据model类生成表，但是sessionFactory一关闭,表就自动删除。
update：最常用的属性，第一次加载hibernate时根据model类会自动建立起表的结构（前提是先建立好数据库），以后加载hibernate时根据model类自动更新表结构，即使表结构改变了但表中的行仍然存在不会删除以前的行。要注意的是当部署到服务器后，表结构是不会被马上建立起来的，是要等应用第一次运行起来后才会。
validate：每次加载hibernate时，验证创建数据库表结构，只会和数据库中的表进行比较，不会创建新表，但是会插入新值。
至此已经完成基础配置，如果您有在Spring下整合使用过它的话，相信你已经感受到Spring Boot的便利之处：JPA的传统配置在persistence.xml文件中，但是这里我们不需要。当然，最好在构建项目时候按照之前提过的最佳实践的工程结构来组织，这样以确保各种配置都能被框架扫描到。

### Spring Boot Jar 启动原理
[Spring Boot Jar 启动原理](https://www.iocoder.cn/Spring-Boot/jar/?github)

### Apollo配置中心

```
踩坑
在JavaWebApplication启动的VM Options加上Eureke的公网ip+port：
-Dapollo.configService=http://127.0.0.1:8080
```

![](../docs/img/Apollo.png)
