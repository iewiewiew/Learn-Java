[TOC]

<h1 align="center">详细说明文档</h1>

> By：weimenghua
> Date：2023.09.03
> Description：

@todo
- dao、service、controller 层方法命名规范
- 封装分页查询



## 1. 开发步骤

### 1.1 后端

SpringBoot 的完整开发流程

#### 1.1.1 初始化项目

步骤一：新建项目，命名为：springboot-example

步骤二：删除 src 目录，在模块下新建模块，命名为：server，

步骤三：在 pom.xml 文件添加依赖：  
在父 pom.xml 添加：
```
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>2.3.5.RELEASE</version>
    <relativePath/>
</parent>
```

在子 pom.xml 添加：   
```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

步骤四：在 resources 目录下添加 application.properties 配置文件，添加内容：
```
server.port=8081
```

#### 1.1.2 开发业务逻辑

步骤一：在 com/wmh/example 新建实体类 entity/ExampleDto.java。

步骤二：创建数据表，执行 resource/init.sql 文件。

步骤三：在 com/wmh/example 新建接口 mapper/ExampleMapper.java。

步骤四：在 com/wmh/example 新建配置 resources/mapper/ExampleMapper.xml。

步骤五：在 com/wmh/example 新建接口 service/ExampleService.java。

步骤六：在 com/wmh/example 新建类 service/ExampleServiceImpl.java。

步骤七：在 com/wmh/example 新建类 controller/ExampleController.java。

#### 1.1.3 启动服务

修改 ServerApplication.java 并运行

```
@Slf4j
@SpringBootApplication
@MapperScan("com.wmh.example.mapper")
public class ExampleApplication {
    public static void main(String[] args) throws Exception{
        // 启动 Spring Boot 应用的核心，它初始化了 Spring 应用上下文，设置了环境，并让应用程序准备好接受请求。
        ConfigurableApplicationContext application = SpringApplication.run(ExampleApplication.class, args);
        Environment env = application.getEnvironment();
        String ip = InetAddress.getLocalHost().getHostAddress();
        String port = env.getProperty("server.port");
        String path = env.getProperty("server.servlet.context-path");

        log.info("\n---------------------------------------------------------------------------------------------------\n\t" +
                "Application is running! Access URLs:\n\t" +
                "Local: \t\thttp://localhost:" + port + "/examples/list" + "\n\t" +
                "----------------------------------------------------------------------------------------------------");
    }
}
```

Swagger 地址：http://127.0.0.1:9999/doc.html

```
示例
curl -X POST -H "Content-Type: application/json" -d '{"name": "iPhone", "price": 8000}' http://example.com/api/add_product

curl -X POST -H "Content-Type: application/json" -d '{}' http://127.0.0.1:9999/example/listByPage

curl -X POST -H "Content-Type: application/json" -d '{}' http://127.0.0.1:9999/example/listByPage?id=&username=&age=&creater=&updater=&createTime=&updateTime=

```

端口号被占用解决方式  

- Linxu：kill -9 `lsof -i:9999 |awk '{print $2}' |tail -1`
- Windows：打开 cmd 执行：netstat -ano | findstr 9999，找到 9999 的 pid，taskkill /f /pid 55852， 或者打开任务管理器-详细信息，根据 pid 杀掉进程

### 1.2 前端

#### 1.2.1 初始化流程

```
安装 vue
npm install -g @vue/cli

初始化 web 项目
vue init webpack web

安装依赖 @todo 依赖版本需要梳理一下
npm install axios@1.5.0 --save

安装 element-ui 组件
npm install element-ui -S

在 src/main.js 引用：
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
Vue.use(ElementUI)
```

#### 1.2.2 开发业务逻辑

步骤一：新建 src/utils/request.js。[参考](https://github.com/PanJiaChen/vue-element-admin/blob/master/src/utils/request.js)

步骤二：新建 src/api/example.js 。

步骤三：新建 src/view/example.vue。注：格式化时间需要 src/utils/utils.js。

步骤四：修改 src/router/index.js。

#### 1.2.3 启动服务

```
npm install
npm run dev
```

### 1.3 联调

步骤一：在 web/config/dev.env.js 增加 BASE_API: '"http://127.0.0.1:9999"',。

步骤二：在 com/wmh/config 新建 CorsConfig.java。解决前后端跨域问题。




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

### 临时记录

[Spring Boot 框架集成 Knife4j](https://doc.xiaominfo.com/docs/action/springboot)  



`data` 和 `params` 的区别

- `data`
  - 用于 POST 请求时，发送的请求体（request body）中的数据。
  - 通常用于发送较复杂的数据结构，例如对象或数组。
- `params`
  - 用于 GET 请求时，附加在 URL 中的查询字符串参数。
  - 主要用于简单的键值对传递，例如分页、过滤条件等。

注意：后端接口如果是设计为接受查询参数，即使是 POST 请求也继续使用 `params`。

