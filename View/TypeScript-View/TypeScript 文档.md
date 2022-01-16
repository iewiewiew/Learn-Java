[TOC]

> By：weimenghua
> Date：2023.01.12
> Decription：

**参考资料**  
[菜鸟教程](https://www.runoob.com/typescript/ts-tutorial.html)



### 一、TypeScript 入门
#### 1.1、TypeScript 简介
TypeScript 是 JavaScript 的一个超集，支持 ECMAScript 6 标准（ES6 教程）。  
TypeScript 由微软开发的自由和开源的编程语言。  
TypeScript 设计目标是开发大型应用，它可以编译成纯 JavaScript，编译出来的 JavaScript 可以运行在任何浏览器上。

#### 1.2、JavaScript 与 TypeScript 的区别
TypeScript 是 JavaScript 的超集，扩展了 JavaScript 的语法，因此现有的 JavaScript 代码可与 TypeScript 一起工作无需任何修改，TypeScript 通过类型注解提供编译时的静态类型检查。    
TypeScript 可处理已有的 JavaScript 代码，并只对其中的 TypeScript 代码进行编译。



### 二、环境搭建
#### 2.1、安装 TypeScript
安装typescript：`npm i typescript -D | npm install ts-node --save-dev | npm install -g ts-node`  
查看typescript版本：`tsc -v  `
执行ts文件：`tsc demoDto.ts` 得到 `demoDto.js` 文件，再执行 `node node_demo.js`   
查看tsc帮助文件：`tsc --help  `

#### 2.2、IDEA 运行 TypeScript 文件
安装 ts-node：`npm i ts-node -D`  
在 `tsconfig.json` 配置：  
```
{
    "ts-node": {
        "compilerOptions": {
            "module": "commonjs"
        }
    },
    "compilerOptions": {
        ...
    }
}
```

![](./imgs/IDEA_TS.png)

#### 2.3、IDEA 自动编译 TypeScript 文件
在 ts 目录下生成 tsconfig.json 文件：`tsc --init ` 
修改 tsconfig.json 的 outDir 为："outDir": "../js", 修改 strict 为："strict": false,
监视 tsconfig 文件，在终端输入：`tsc -p tsconfig.json --watch`



### 三、TypeScript 教程
#### 3.1、TypeScript 基础语法
TypeScript 程序由以下几个部分组成：
- 模块
- 函数
- 变量
- 语句和表达式
- 注释

##### 例子
demoDto.ts代码：
```
const hello : string = "Hello World!"
console.log(hello)
```
编译：tsc demoDto.ts，得到如下js代码：
```
var hello = "Hello World!";
console.log(hello);
```
执行js文件：`node node_demo.js `   
同时编译多个js文件：`tsc demoDto.ts demo1.ts demo2.ts`

#### 3.2、基本数据类型
参见 demoDto/data_type.ts

#### 3.3、面向对象
TypeScript 是一种面向对象的编程语言。 面向对象主要有两个概念：对象和类。
