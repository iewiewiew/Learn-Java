[TOC]

<h1 align="center">JavaBase</h1>

> By：weimenghua
> Date：2023.09.03
> Description：



## 1. Java 教程

### 基础1

- 面向对象
  - 方法
  - 重载
  - 封装
  - 继承
  - 多态
  
- 抽象类

- 接口

- 枚举

- 常用类
  - String
  - 日期时间
  
- 集合类

- 泛型

- 注解

- 异常处理

- 多线程

- IO 流

- 反射


### 基础2

- 序列化和反序列化 

序列化：将对象写入到IO流中  
反序列化：从IO流中恢复对象  
Serializable接口是一个「标记接口」，不用实现任何方法，标记当前类对象是可以序列化的，是给JVM看的。  
序列化机制允许将这些实现序列化接口的对象转化为字节序列，这些字节序列可以保证在磁盘上或者网络传输后恢复成原来的对象。序列化就是把对象存储在JVM以外的地方，序列化机制可以让对象脱离程序的运行而独立存在。
为什么需要序列化：数据需要序列化以后才能在服务端和客户端之间传输。这个服务端和客户端的概念是广义的，可以在网络上，也可以在同一台机器的不同进程中，甚至在同一个进程中进行通信。在传统编程中，对象是通过调用栈间接的与客户端交互，但在面向服务的编程中，客户端永远都不会直接调用实例。

- 深拷贝和浅拷贝

深拷贝就是将所有属性均拷贝到另外一个对象中，将其中任何一个对象任何一个属性发生变化时，另外一个对象不受任何影响。  
浅拷贝就是直接使用 "=" 给基本类型赋值（即拷贝引用）。

- 面向对象和面向过程

面向对象：强调的是对象(实体)。语言：C++  Java  C#。
面向过程：强调的是过程(动作)。语言：C语言。

- 面向对象的三大特征

  - 封装：隐藏对象的属性和实现细节，用private进行修饰，仅对外提供访问方式。  
  - 继承：多个类具有共同的属性（成员变量）和行为（成员方法），将这些公共部分抽取出来定义一个新的类，然后这个抽取出来新的类叫做父类或者超类，其他被抽取的类叫做子类，父类和子类之间具有继承关系，子类可以直接访问父类非私有化成员变量，重写父类非私有化方法，通过super.get()访问父类私有化成员变量。  
  - 多态：不同类的对象对同一消息做出反应，即同一消息可以根据对象的不同发送不同的行为方式（根据不同对象发送不一样的内容，但是方法名是同一个，比如一个按键在不同页面上有不同的功能）。  
  - 静态多态（重载，方法名相同，参数个数和类型都不相同），在编译时期即知道调用哪个方法（输入对应参数调用对应方法）。  
  - 动态多态（重写，重写父类中同名成员方法）动态绑定。  
  - 多态的作用：消除类型之间耦合的关系。  

- JVM内存管理

JVM内存管理，根据JVM规范，JVM把内存划分成了如下几个区域：
1. 方法区（Method Area）  
2. 堆区（Heap）  
3. 虚拟机栈（VM Stack）  
4. 本地方法栈（Native Method Stack）  
5. 程序计数器（Program Counter Register）  
随着程序的运行，内存中的实例对象、变量等占据的内存越来越多，如果不及时进行回收，会降低程序运行效率，甚至引发系统异常。  
在上面介绍的五个内存区域中，有3个是不需要进行垃圾回收的：本地方法栈、程序计数器、虚拟机栈。因为他们的生命周期是和线程同步的，随着线程的销毁，他们占用的内存会自动释放。所以，只有方法区和堆区需要进行垃圾回收，回收的对象就是那些不存在任何引用的对象。

- Java 反射

参考资料：[Java 程序员都需要懂的 反射！](https://mp.weixin.qq.com/s/535MXKKRe7u8ux8HAoCEAA)  
通过Class对象创建出对象，获取出构造器，成员变量，方法；  
通过反射的API修改成员变量的值，调用方法。
使用反射的原因：提高程序的灵活性；屏蔽掉实现的细节，让使用者更加方便好用。



### Maven 仓库

1. Maven仓库分类

Maven仓库分为本地仓库，私服仓库，远程仓库。  
当我们在pom文件中依赖了一个jar包，maven会先去本地仓库加载，如果本地仓库没有回去maven私服找，如果maven私服也没有，maven私服会从远程仓库下载到私服仓库，然后再返回给本地仓库。

2. 一方库、二方库、三方库是什么？

一方库：本工程中的各模块的相互依赖。  
二方库：公司内部的依赖库，一般指公司内部的其他项目发布的jar包。  
三方库：公司之外的开源库， 比如apache、ibm、google等发布的依赖。

3. 为什么要搭建maven私服

服务器下载配置直接找到私服，不需要连接外网，走局域网，速度快，安全性高。  
每次要下载依赖无需重复从远程仓库下载，从私服下载，速度快。  
公司内部的jar包无法发布到中央仓库，也不能暴露给外部，要实现共享就需要搭建maven私服仓库。

4. 第三方仓库代理

在本地将我们maven的远程仓库指向了我们公司私服。当我们要下载私服中没有的依赖时，会先去中央仓库找，中央仓库也不存在，这时maven私服就到第三方代理仓库去下载。

5. 快照版和正式版的区别

snapshot快照仓库用于保存开发过程中的不稳定版本，release正式仓库则是用来保存稳定的发行版本。maven会根据模块的版本号（pom文件中的version）中是否带有-SNAPSHOT来判断是快照版本还是正式版本。  
如果是快照版本，那么在mvn deploy时会自动发布到快照版本库中，而使用快照版本的模块，在不更改版本号的情况下，直接编译打包时，maven会自动从镜像服务器上下载最新的快照版本。  
如果是正式发布版本，那么在mvn deploy时会自动发布到正式版本库中。而使用正式版本的模块，在不更改版本号的情况下，编译打包时如果本地已经存在该版本的模块则不会主动去镜像服务器上下载。  
基于以上特点，在开发阶段可以将公用库的版本设置为快照版本，而被依赖组件则引用快照版本进行开发，在公用库的快照版本更新后，不需要修改pom文件提示版本号来下载新的版本，直接mvn执行相关编译、打包命令即可重新下载最新的快照库。

6. 安装JAR包到本地仓库和远程仓库

1、Maven依赖demo

```
<dependency>
     <groupId>io.metersphere</groupId>
     <artifactId>jmeter-plugins-dubbo</artifactId>
     <version>2.7.12</version>
</dependency>
```

2、Maven安装JAR包到本地仓库

```
格式：mvn install:install-file -Dfile=jar包的位置 -DgroupId=groupId -DartifactId=artifactId -Dversion=version -Dpackaging=jar

例子：mvn install:install-file -Dfile=D:\tmp\metersphere\backend-1.9\BOOT-INF\lib\jmeter-plugins-dubbo-2.7.12.jar -DgroupId=io.metersphere -DartifactId=jmeter-plugins-dubbo -Dversion=2.7.12 -Dpackaging=jar
```

3、Maven安装JAR包到远程仓库
```
格式：mvn deploy:deploy-file -DgroupId=groupId -DartifactId=artifactId -Dversion=version -Dpackaging=jar -Dfile=路径 -Durl=url

例子：mvn deploy:deploy-file -Dfile=D:\tmp\metersphere\backend-1.9\BOOT-INF\lib\jmeter-plugins-dubbo-2.7.12.jar -DgroupId=io.metersphere -DartifactId=jmeter-plugins-dubbo -Dversion=2.7.12 -Dpackaging=jar -Durl=http://127.0.0.1:8081/repository/public/

例子：mvn deploy:deploy-file -Dmaven.test.skip=true  \
-Dfile=D:\tmp\jmeter-plugins-dubbo-2.7.4-jar-with-dependencies.jar \
-DgroupId=io.metersphere -DartifactId=jmeter-plugins-dubbo \
-Dversion=2.7.4 \
-Dpackaging=jar \
-Durl=http://127.0.0.1:8081/repository/public/
```

阿里云镜像地址
```
<mirror>
    <id>aliyun</id>
    <name>aliyun Maven</name>
    <mirrorOf>*</mirrorOf>
    <url>http://maven.aliyun.com/nexus/content/groups/public/</url>
</mirror>
```

把 sdk 发布到 maven 仓库

将 SDK 发布到 Maven 仓库的 pom.xml 文件示例
```
<project>
  <groupId>com.example</groupId>
  <artifactId>my-sdk</artifactId>
  <version>1.0.0</version>
 
  <distributionManagement>
    <repository>
      <id>my-maven-repo</id>
      <url>https://example.com/maven-repo/</url>
    </repository>
  </distributionManagement>
 
  <build>
    <plugins>
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-deploy-plugin</artifactId>
        <version>3.0.0-M1</version>
        <configuration>
          <altDeploymentRepository>my-maven-repo::default::https://example.com/maven-repo/</altDeploymentRepository>
        </configuration>
      </plugin>
    </plugins>
  </build>
</project>
```

Maven 仓库的访问凭据，$MAVEN_HOME/conf/settings.xml 文件
```
<servers>
  <server>
    <id>my-maven-repo</id>
    <username>your-username</username>
    <password>your-password</password>
  </server>
</servers>
```

将 SDK 发布到 Maven 仓库 `mvn deploy`

7. Maven常用命令

- mvn compile
- mvn test
- mvn clean
- mvn pakage
- mvn install
- mvn deploy

8. package、install、deploy的区别

- package命令完成了项目编译、单元测试、打包功能，但没有把打好的可执行jar包（war包或其它形式的包）布署到本地maven仓库和远程maven私服仓库。
- install命令完成了项目编译、单元测试、打包功能，同时把打好的可执行jar包（war包或其它形式的包）布署到本地maven仓库，但没有布署到远程maven私服仓库。
- deploy命令完成了项目编译、单元测试、打包功能，同时把打好的可执行jar包（war包或其它形式的包）布署到本地maven仓库和远程maven私服仓库。



### Tomcat 容器

1. Tomcat目录结构

1、bin

bin目录主要是用来存放tomcat的命令，主要有两大类，一类是以.sh结尾的（linux命令），另一类是以.bat结尾的（windows命令）。  
很多环境变量的设置都在此处，例如可以设置JDK路径、tomcat路径 startup 用来启动tomcat shutdown 用来关闭tomcat 修改catalina可以设置tomcat的内存。

2、conf

conf目录主要是用来存放tomcat的一些配置文件。  
server.xml可以设置端口号、设置域名或IP、默认加载的项目、请求编码 web.xml可以设置tomcat支持的文件类型 context.xml可以用来配置数据源之类的 tomcat-users.xml用来配置管理tomcat的用户与权限 在Catalina目录下可以设置默认加载的项目。

3、lib

lib目录主要用来存放tomcat运行需要加载的jar包。 例如，像连接数据库的jdbc的包我们可以加入到lib目录中来。

4、logs

logs目录用来存放tomcat在运行过程中产生的日志文件，非常重要的是在控制台输出的日志。（清空不会对tomcat运行带来影响） 在windows环境中，控制台的输出日志在catalina.xxxx-xx-xx.log文件中 在linux环境中，控制台的输出日志在catalina.out文件中。

5、temp

temp目录用户存放tomcat在运行过程中产生的临时文件。（清空不会对tomcat运行带来影响）

6、webapps

webapps目录用来存放应用程序，当tomcat启动时会去加载webapps目录下的应用程序。可以以文件夹、war包、jar包的形式发布应用。 当然，你也可以把应用程序放置在磁盘的任意位置，在配置文件中映射好就行。

7、work

work目录用来存放tomcat在运行时的编译后文件，例如JSP编译后的文件。 清空work目录，然后重启tomcat，可以达到清除缓存的作用。

2. Tomcat启动脚本参数

```
JAVA_OPTS="-server -Xms512m -Xmx1024m  -XX:MaxNewSize=512m -XX:PermSize=128m -XX:MaxPermSize=256m -Djava.awt.headless=true"
-Xms256m JVM初始分配的堆内存, 生产环境建议与Xmx相同, 设为1024m以上
-Xmx512m JVM最大允许分配的堆内存, 生产环境建议设为1024m以上
-Xss128k 线程堆栈大小, JDK5以上一般设置为256k或以上, 与 -XX:ThreadStackSize 的区别

-XX:PermSize=64m JVM初始分配的非堆内存, 不会被回收, 生产环境建议与maxPermSize相同, 设为256m以上
-XX:MaxNewSize=512m JVM堆区域新生代内存的最大可分配大小(PermSize不属于堆区), 生产环境建议设为800M-1024M
-XX:MaxPermSize=128M JVM最大允许分配的非堆内存, 生产环境建议设置为256m以上
-Xmn512m 是上面两个的快捷定义方式, 等同于上面两个都为512m
```



### 常用 Java 命令

- jps：用于查看JAVA进程编号

- jstat：用于打印GC回收统计信息，便于分析是否出现FGC等情况

- jstack：用于dump出指定进程中的线程堆栈快照信息，便于排查应用是否有锁、死锁或排查CPU占比高的线程代码

- jmap：用于dump出指定进程中当前内存的快照信息，便于分析内存的内容结构，从而定位内存泄漏等问题

- jhat：用于与jmap搭配使用，用来分析jmap生成的dump

- jconsole：Java GUI监视工具，可以以图表化的形式显示各种数据，并可通过远程连接监视远程的服务器VM

- jvisualvm：一个基于图形化界面的，可以查看本地及远程的JAVA GUI监控工具，可以查看CPU、堆、线程、GC等

- jmc：JDK自带图形界面监控工具。JMC打开性能日志后可查看一般信息、内存、代码、线程、I/O、系统、事件 功能

  

## 2. 综合信息

### 经典面试题

1. 为什么重写 equals 还要重写 hashcode？
2. == 和 equals 比较的区别？
3. final 关键字的作用？
4. 介绍 Java 的集合类？
5. ArrayList 和 LinkedList 的区别？

### Jacoco单元覆盖率

JaCoCo官方文档：https://www.eclemma.org/jacoco/trunk/doc/index.html
JaCoCo应该为基于Java VM的环境中的代码覆盖率分析提供标准技术。重点是提供一个轻量级，灵活且文档齐全的库，以与各种构建和开发工具集成。
添加依赖后，执行：mvn clean test。

```
<dependency>
    <groupId>org.jacoco</groupId>
    <artifactId>jacoco-maven-plugin</artifactId>
    <version>0.8.7</version>
</dependency>
```
```
<build>
        <plugins>
            <plugin>
                <groupId>org.jacoco</groupId>
                <artifactId>jacoco-maven-plugin</artifactId>
                <version>0.8.7</version>
                <executions>
                    <execution>
                        <goals>
                            <goal>prepare-agent</goal>
                        </goals>
                    </execution>
                    <execution>
                        <id>report</id>
                        <phase>test</phase>
                        <goals>
                            <goal>report</goal>
                        </goals>
                        <configuration>
                            <!--定义输出的文件夹-->
                            <outputDirectory>target/jacoco-report</outputDirectory>
                        </configuration>
                    </execution>
                </executions>
            </plugin>
        </plugins>
    </build>
```



### Cobertura单元覆盖率

[Cobertura单元覆盖率](http://www.mojohaus.org/cobertura-maven-plugin/usage.html)
添加依赖后，执行：mvn -B cobertura:cobertura -Dmaven.test.failure.ignore=true
注意：报告在site目录下的index.html
```
<plugin>
          <groupId>org.codehaus.mojo</groupId>
          <artifactId>cobertura-maven-plugin</artifactId>
          <version>2.7</version>
          <configuration>
              <instrumentation>
                  <ignores>
                      <ignore>com.example.boringcode.*</ignore>
                  </ignores>
                  <excludes>
                      <exclude>com/example/dullcode/**/*.class</exclude>
                      <exclude>com/example/**/*Test.class</exclude>
                  </excludes>
              </instrumentation>
              <check/>
          </configuration>
          <executions>
              <execution>
                  <goals>
                      <goal>clean</goal>
                  </goals>
              </execution>
          </executions>
</plugin>
```



## 3. 知识碎片

导出内存dump文件：
保存了堆内存现场
jmap -dump:format=b,file=heap.dump pid
强制保存了堆内存现场
jmap -F -dump:format=b,file=heap.dump pid

保存了线程栈的现场
jstack pid > jstack.log

执行 Java 报错：
```
1.8.jdk/Contents/Home/jre/lib/rt.jar:/Users/menghuawei/.config/spring-invoke/invoke/lib/spring-invoke-starter.jar algorithm.sort.BubbleSort
错误: 找不到或无法加载主类 algorithm.sort.BubbleSort
Process finished with exit code 1
```

解决：点击上方的方法名 > Edit Configurations > Build and run 的 -cp 选择对应的模块。注：不知道抽啥风，默认模块全部成其它的

4、Windows调用jar包  
java -jar zookeeper-dev-ZooInspector.jar

5、Linux调用jar包  
/usr/java/jdk1.8.0_271/bin/java  -Dparam=test -cp /tmp/Learn-Java.jar utils.WriteToPDF  
代码：String projectNo = System.getProperty("param");  
传参：-Dparam=test  
问题：如果JDK编译版本和执行版本不一致（编译版本比执行版本高），会报错  
解决：使用一致的JDK版本（可指定版本，在Linux解压即可，无需设置环境变量）  

XXXXXXX-1.0-SNAPSHOT.jar中没有主清单属性的解决办法  
1、在pom.xml文件中插入

```
<build>
    <plugins>
        <plugin>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-maven-plugin</artifactId>
        </plugin>
    </plugins>
</build>
```

2、双击IDEA右侧Maven Projects的lifecycle下的package，打包成jar，重新执行java -jar Java-Web-1.0-SNAPSHOT.jar。

pom 文件 <packaging>pom</packaging>、<packaging>jar</packaging>、<packaging>war</packaging> 的区别
- POM 类型主要用于项目管理和依赖管理，不生成可执行文件；
- JAR 类型用于开发可执行的 Java 应用程序，生成 JAR 文件；
- WAR 类型用于开发 Web 应用程序，生成 WAR 文件。

BOM（Bill of Materials）是由Maven提供的功能,它通过定义一整套相互兼容的jar包版本集合，使用时只需要依赖该BOM文件，即可放心的使用需要的依赖jar包，且无需再指定版本号。BOM的维护方负责版本升级，并保证BOM中定义的jar包版本之间的兼容性。

检查依赖：mvn dependency:tree |grep slf4j