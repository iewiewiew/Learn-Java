/**
 *@author       weimenghua
 *@time         2022-07-14 12:31
 *@description  服务端
 */

// 执行node node_server.js，访问：http://127.0.0.1:8888/
// 分析Node.js 的 HTTP 服务器：
// 第一行请求（require）Node.js 自带的 http 模块，并且把它赋值给 http 变量。
// 接下来我们调用 http 模块提供的函数： createServer 。这个函数会返回 一个对象，这个对象有一个叫做 listen 的方法，这个方法有一个数值参数， 指定这个 HTTP 服务器监听的端口号。

var http = require('http');

http.createServer(function (request, response) {

    // 发送 HTTP 头部
    // HTTP 状态值: 200 : OK
    // 内容类型: text/plain
    response.writeHead(200, {'Content-Type': 'text/plain'});

    // 发送响应数据 "Hello World"
    response.end('Hello World\n');
}).listen(8888);

// 终端打印如下信息
console.log('Server running at http://127.0.0.1:8888/');