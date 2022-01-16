/**
 *@author       weimenghua
 *@time         2022-07-15 15:41
 *@description  函数
 */

function say(word){
    console.log(word);
}

function execute(demo, value){
    demo(value);
}

// 把 say 函数作为 execute 函数的第一个变量进行了传递。这里传递的不是 say 的返回值，而是 say 本身！
execute(say, "呱呱大王")