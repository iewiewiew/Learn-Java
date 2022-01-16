/**
 * @Author      weimenghua
 * @Date        2022-07-06 17:13
 * @Description TypeScript 函数
 */
function demo() {
    console.log("这是一个函数");
}
demo(); // 调用函数
// 无参函数
function demo1() {
    return "这是一个string";
}
// 调用函数
function demo2() {
    var str = demo1();
    console.log(str);
}
demo2();
// 带参函数
function demo3(x, y) {
    return x + y;
}
console.log(demo3(1, 2));
// Lambda 函数 Lambda 函数也称之为箭头函数。箭头函数表达式的语法比函数表达式更短。
var demo4 = function (x) { return 10 + x; };
console.log(demo4(1));
var demo5 = function (x) {
    x = 10 + x;
    console.log(x);
};
demo5(2);
