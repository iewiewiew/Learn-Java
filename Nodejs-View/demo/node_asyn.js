/**
 *@author       weimenghua
 *@time         2022-07-14 12:31
 *@description  阻塞和非阻塞
 */

// 阻塞：文件读取完成之后才执行程序
var fs = require("fs");
var data = fs.readFileSync("../files/input.txt");
console.log(data.toString())
console.log("阻塞：读取txt文件")

// 非阻塞：在读取文件的同时执行接下来的代码
fs.readFile("../files/input.txt", function (err, data){
    if (err) return console.log(err);
    console.log(data.toString());
});
console.log("非阻塞：读取txt文件")
