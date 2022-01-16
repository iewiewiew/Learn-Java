[TOC]

<h1 align="center">VueView</h1>

> By：weimenghua  
> Date：2023.09.03  
> Description：



**参考资料**  
[vue-admin-template](https://github.com/PanJiaChen/vue-admin-template/blob/master/README.md)



### 1. 启动项目
```
1、切换目录
cd vueview

2、安装依赖
npm install  
   
3、报错的时候使用
npm install --ignore-scripts

4、打包
npm run build

5、运行
npm run dev
在 config/dev.env.js 设置后端地址

6、访问地址
http://127.0.0.1:8888/#/demo
```



### 2. 搭建 vue

```
1、安装 cnpm
npm install -g cnpm --registry=https://registry.npm.taobao.org
npm install -g cnpm --registry=http://registry.npmmirror.com

2、安装vue
npm install -g @vue/cli

3、查看vue版本
vue -V / vue --version

4、新建vue项目
进入目录所在位置：vue init webpack (默认当前文件名) | vue init webpack vueview(新建项目名 vueview)

5、安装依赖
npm install webpack-dev-server@1.16.2 -g
npm install --save extract-text-webpack-plugin
npm install --save axios   // 主要用来发送请求，可理解为 ajax
npm install qs -S　　       // 包装传回后台的数据防止接收不到
npm install vue-router     // vue 路由
```



### 3. 使用 element-ui

[element-ui地址](https://element.eleme.cn/#/zh-CN/component/installation)  

安装 element-ui 组件：  
进入项目 vueview 目录下执行：`npm install element-ui -S`  
在 main.js 引用：
```
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
Vue.use(ElementUI)
```



### 5. 项目部署

1、安装 Nginx
```
docker pull nginx
docker run --name nginx -d -p 7777:80 nginx
docker exec -it nginx bash
```

2、编写 Dockerfile
```
FROM nginx

RUN rm /etc/nginx/conf.d/default.conf
ADD default.conf /etc/nginx/conf.d/

RUN rm /usr/share/nginx/html/index.html
COPY dist/ /usr/share/nginx/html/
```

3、配置 Nginx
详见 nginx.conf、default.conf

4、注意
使用 Nginx 代理后直接访问的是前端的IP+端口

5、进入容器
docker exec -it my-vue bash

从容器复制文件到宿主机
docker cp nginx:/etc/nginx/nginx.conf ./nginx.conf

**nginx.conf**
```
user  nginx;
worker_processes  auto;

error_log  /var/log/nginx/error.log notice;
pid        /var/run/nginx.pid;


events {
    worker_connections  1024;
}


http {
    include       /etc/nginx/mime.types;
    default_type  application/octet-stream;

    log_format  main  '$remote_addr - $remote_user [$time_local] "$request" '
                      '$status $body_bytes_sent "$http_referer" '
                      '"$http_user_agent" "$http_x_forwarded_for"';

    access_log  /var/log/nginx/access.log  main;

    sendfile        on;
    #tcp_nopush     on;

    keepalive_timeout  65;

    #gzip  on;

    include /etc/nginx/conf.d/*.conf;
}
```

**default.conf**  
从容器复制文件到宿主机  
docker cp nginx:/etc/nginx/conf.d/default.conf ./default.conf
```
server {
    listen       80;
    server_name  127.0.0.1;

    location / {
        root   /usr/share/nginx/html;
        index  index.html index.htm;
        try_files $uri $uri/ /index.html =404;
    }

    location /demo {
        proxy_set_header Host $http_host;
        proxy_set_header X-Real-IP $remote_addr;
        proxy_set_header REMOTE-HOST $remote_addr;
        proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
        proxy_pass http://127.0.0.1:9999;
    }

    error_page   500 502 503 504  /50x.html;
    location = /50x.html {
        root   html;
    }
}
```
