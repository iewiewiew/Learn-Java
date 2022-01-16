/**
 *@author       weimenghua
 *@time         2022-07-12 12:18
 *@description  String 对象用于处理文本（字符串）。
 */
var txt = new String("A呱呱大王");
var txt1 = "呱呱大王";
console.log("对创建该对象的引用：" + txt.constructor);
console.log("返回字符串的长度：" + txt.length);
console.log("返回在指定位置的字符串：" + txt.charAt(2));
console.log("连接两个或更多字符串，并返回新字符串：" + txt.concat("two"));
console.log("把字符串转换为大写：" + txt.toUpperCase());
console.log("把字符串转换为小写：" + txt.toLowerCase());
