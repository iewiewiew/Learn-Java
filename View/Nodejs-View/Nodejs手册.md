[TOC]

---

### Nodejs简介
简单的说 Node.js 就是运行在服务端的 JavaScript。
Node.js 是一个基于 Chrome JavaScript 运行时建立的一个平台。
Node.js 是一个事件驱动 I/O 服务端 JavaScript 环境，基于 Google 的 V8 引擎，V8 引擎执行 Javascript 的速度非常快，性能非常好。  
[Node.js教程](https://www.runoob.com/nodejs/nodejs-tutorial.html)


### 环境搭建
查看node版本：node -v  
初始化项目：node init -y  
执行nodejs：node node_demo.js  
输入node进入命令交互模式  

安装依赖：  
npm install mocha        # 测试报告  
npm install express      # 本地安装  
npm install express -g   # 全局安装  
更新模块：npm update express  
查看版本号：npm list express  
查看安装信息：npm list -g  
查看仓库地址：npm get registry
设置仓库镜像源：npm config set registry https://registry.npm.taobao.org


单元测试：npm run test  
