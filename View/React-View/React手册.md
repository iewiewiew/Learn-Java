### React简介
React 是一个用于构建用户界面的 JAVASCRIPT 库。  
React 主要用于构建 UI，很多人认为 React 是 MVC 中的 V（视图）。  
React 起源于 Facebook 的内部项目，用来架设 Instagram 的网站，并于 2013 年 5 月开源。  
React 拥有较高的性能，代码逻辑非常简单，越来越多的人已开始关注和使用它。 


### React 特点
1. 声明式设计 −React采用声明范式，可以轻松描述应用。
2. 高效 −React通过对DOM的模拟，最大限度地减少与DOM的交互。
3. 灵活 −React可以与已知的库或框架很好地配合。
4. JSX − JSX 是 JavaScript 语法的扩展。React 开发不一定使用 JSX ，但我们建议使用它。
5. 组件 − 通过 React 构建组件，使得代码更加容易得到复用，能够很好的应用在大项目的开发中。
6. 单向响应的数据流 − React 实现了单向响应的数据流，从而减少了重复代码，这也是它为什么比传统数据绑定更简单。


### 学习教程
1. https://www.ruanyifeng.com/blog/2015/03/react.html
2. https://www.runoob.com/react/react-tutorial.html


### 环境搭建
#### 环境搭建
1. 安装依赖：npm install --save react react-dom
2. 安装create-react-app：cnpm install -g create-react-app
3. 创建React项目：create-react-app react-view  注意：目录名不能大写, 但是可以先创建一个大写目录React-View，再在该目录下执行create-react-app react-view
4. cd React-View执行npm start，访问：http://localhost:3000/，成功搭建React环境
![](./imgs/Learn%20React.png)

#### 目录结构说明
React-View/
- node_modules/
- public/
  - favicon.ico
  - index.html
  - manifest.json  #manifest.json 指定了开始页面 index.html，是代码执行的源头
- src/
  - App.css
  - App.js         #src/App.js为根组件，其style设置在App.css中
  - App.test.js
  - index.css
  - index.js       #src/index.js为应用入口文件，目的是渲染App组件
  - logo.svg
  - README.md
  - package.json
  - .gitignore

