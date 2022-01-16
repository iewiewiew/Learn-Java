[TOC]

<h1 align="center">JavaWeb</h1>

> By：weimenghua
> Date：2023.09.03
> Description：JavaWeb 文档



## 1. JavaWeb 启动

### 1.1 配置数据库

1、JDBC 配置
JDBC 配置文件：src/main/resources/application.properties，修改为对应的配置信息
```
spring.datasource.url=jdbc:mysql://127.0.0.1:3306/dbname?serverTimezone=Asia/Shanghai
spring.datasource.username=root
spring.datasource.password=root
```

2、SQL 语句
SQL 语句文件：src/main/resources/dbname.sql

### 1.2 启动 JavaWeb

1、启动 JavaWeb

- 方式一：双击 bin/start.bat（Windows） / sh bin/start.sh（Mac）
- 方式二：进入 Java-Web 的 pom.xml 所在目录，执行：`mvn clean package && java -jar ./target/Java-Web-1.0-SNAPSHOT.jar`
- 方式三：在 IDEA 双击 Maven 的 clean、install，运行 src/main/java/com/wmh/JavaWebApplication.java
- 方式四：k8s
```
kubectl apply -f ./Java-Web/bin/k8s.yml
kubectl get pod -A
kubectl get svc -A (80映射的端口就是访问的端口)

kubectl delete pod springboot-web-59d8f7c9b4-cdwn8
kubectl delete svc springboot-web
```

2、验证  
在浏览器访问 http://127.0.0.1:9999/demo/list

3、端口号被占用解决方式  
Linxu：kill -9 `lsof -i:9999 |awk '{print $2}' |tail -1`
Windows：打开 cmd 执行：netstat -ano | findstr 9999，找到 9999 的 pid，taskkill /f /pid 55852， 或者打开任务管理器-详细信息，根据 pid 杀掉进程

### 1.3 接口地址

Swagger 地址：http://127.0.0.1:9999/doc.html

**Demo 模块**

- 查询 demo 列表接口：http://127.0.0.1:9999/demo/list

- 根据 id 查找 demo 接口：http://127.0.0.1:9999/demo/list/1

- 新增 demo 地址接口：http://127.0.0.1:9999/demo/add

```
curl -H "Content-Type:application/json" -X POST -d '{"id":"1","username": "admin","password": "123456"}' 'http://127.0.0.1:9999/demo/add'
```

- 更新 demo 接口：http://127.0.0.1:9999/demo/update

```
curl -H "Content-Type:application/json" -X POST -d '{"id":"1","username": "usernameup","password": "123456789"}' 'http://127.0.0.1:9999/demo/update'
```

- 删除 demo 接口：http://127.0.0.1:9999/demo/delete/1

```
curl -H "Content-Type:application/json" -X DELETE 'http://127.0.0.1:9999/demo/delete/1'
```

- 上传 Excel 接口：

```
curl -X POST http://127.0.0.1:9999/demo/upload -F "file=@demo.xlsx"
```

**其它**

- 上传文件地址：http://127.0.0.1:9999/uploadpage

- dubbo 接口：http://127.0.0.1:9999/sayHello

- redis接口地址：http://127.0.0.1:9999/redis

- 客户端发送内容：http://127.0.0.1:63342/Learn-Java/Java-Web/com/wmh/view/socket.html

- 服务端发送内容：http://127.0.0.1:9999/wbtest/sendMsg/test_websocket

### 1.4 接口文档

[Spring Boot 框架集成 Knife4j](https://doc.xiaominfo.com/docs/action/springboot)  
接口文档：http://127.0.0.1:9999/doc.html#/home



## 2. JavaWeb 步骤

详细流程
1. 新建 SpringBoot 工程
2. 修改 pom.xml 文件
3. 准备数据库，执行 resource/dbname.sql 
4. 修改 application.properties 文件，添加数据库配置、项目启动端口、mapper.xml 映射文件的位置、日志隔离级别等配置
5. 创建数据库对应的实体类
6. 建立实体类，字段名和数据库表字段保持一致，目录名：dto
7. 建立 mapper 接口，定义操作数据库的工作项，目录名：dao
8. 建立 mapper.xml 文件，定义 SQL 语句，目录名：resources/mapper
9. 建立 service 类，处理业务逻辑，目录名：service、service/impl
10. 建立 controller 类，即定义接口，目录名：controller


## 2. 项目实践

### ruoyi-vue-pro

安装油猴脚本 Fuck-Yudao 查看 [ruoyi-vue-pro 开发指南](https://doc.iocoder.cn/)

后端
```
克隆仓库
git clone https://github.com/YunaiV/ruoyi-vue-pro.git

初始化 sql
create database `ruoyi-vue-pro`;
mysql -h localhost -uroot -p123456 ruoyi-vue-pro <sql/mysql/ruoyi-vue-pro.sql

启动服务
cd tmp/ruoyi-vue-pro/yudao-server
mvn clean package
java -jar target/yudao-server.jar

在编辑器运行文件
yudao-server/src/main/java/cn/iocoder/yudao/server/YudaoServerApplication.java
```

前端
```
git clone https://github.com/yudaocode/yudao-ui-admin-vue3.git

cd tmp/yudao-ui-admin-vue3

npm config set registry https://registry.npmmirror.com
npm install -g pnpm
pnpm install
npm run dev
````

访问服务
http://localhost:80

查看接口文档
http://127.0.0.1:48080/doc.html

新建模块演习

https://doc.iocoder.cn/module-new/#_3-%E6%96%B0%E5%BB%BA-demo-biz-%E5%AD%90%E6%A8%A1%E5%9D%97

### vue-element-admin

[vue-element-admin 前端模板](https://github.com/PanJiaChen/vue-element-admin)
[vue-element-admin 帮助文档](https://panjiachen.github.io/vue-element-admin-site/zh/guide/)

```
git clone https://github.com/PanJiaChen/vue-element-admin.git
cd vue-element-admin
```

### vue-admin-template

```
git clone https://github.com/PanJiaChen/vue-admin-template.git

cd vue-admin-template
npm install
npm run dev

在 /src/utils/request.js 调整：
修改 baseURL: process.env.VUE_APP_BASE_API, 为 baseURL: 'http://127.0.0.1:9999',
修改 if (1 !== 1) { 为 if (res.code !== 20000) {

把以下文件复制到 vue-element-admin 对应位置
Vue-View/vueview/src/api/httpDemo.js
Vue-View/vueview/src/utils/scrollTo.js
Vue-View/vueview/src/components/Pagination
Vue-View/vueview/src/views
```



## 3. 知识碎片

### 临时记录

Java 实体类为什么分为 DemoReqDTO 和 DemoRespDTO？
请求（Req）和响应（Resp）的不同用途
DemoReqDTO主要用于接收外部传入的数据。例如，在一个 Web 服务中，当客户端发送一个 HTTP 请求来创建一个新的用户账户时，DemoReqDTO会包含诸如用户名、密码、邮箱等用户输入的信息。它的结构是根据客户端需要提供的数据来设计的，重点在于获取输入。
DemoRespDTO则是用于向外部返回数据。继续以创建用户账户为例，服务器处理完账户创建请求后，DemoRespDTO可能会包含新创建用户的账户 ID、创建成功的消息等信息返回给客户端。这种分离使得每个 DTO（数据传输对象）的职责非常明确，易于理解和维护。


### 踩坑

- 踩坑1
  现象：SpringBoot 使用 knife4j 无法引入 @EnableSwagger2WebMvc，
  解决：把原先的 swagger2 注释掉，点击 Maven 的刷新按钮并重新 clean install。

- 踩坑2
  问题：启动报错
  解决：升级 SpringBoot 版本到 2.3.5.RELEASE。

- 踩坑3
  现象：报错：Cannot resolve symbol 'log'
  解决：安装 Lombok 插件

- 踩坑4
  现象：同一个接口以不同的 HTTP 方法（如 GET、POST、DELETE）重复出现
```
@RequestMapping(value = "demo", method = RequestMethod.GET)
public Object getDemo() { ... }

@RequestMapping(value = "demo", method = RequestMethod.POST)
public Object addDemo() { ... }

改为

@GetMapping("demo")
public Object getDemo() { ... }

@PostMapping("demo")
public Object addDemo() { ... }
```

- 踩坑5
  问题：去掉新增 Demo 时的 id 字段
  解决：在 resources/mapper/DemoMapper.xml 的 insert 语句去掉 id 字段

- 踩坑5
  现象：本地仓库有 EasyExcel 包，运行时报错找不到
  解决：
```
<dependency>
    <groupId>com.alibaba.excel</groupId>
    <artifactId>easyexcel</artifactId>
    <version>3.3.2</version>
    <!-- 添加如下配置，检查这里的范围 -->
    <scope>compile</scope>
</dependency>
```
