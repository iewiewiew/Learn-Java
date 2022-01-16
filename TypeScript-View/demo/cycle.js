/**
 * @Author      weimenghua
 * @Date        2022-07-06 16:26
 * @Description TypeScript 循环语句
 */
// 计算 5 的阶乘， for 循环生成从 5 到 1 的数字，并计算每次循环数字的乘积。
// @ts-ignore
var num = 5;
var i;
var tmp = 1;
for (i = num; i >= 1; i--) {
    tmp *= i;
    console.log(i, tmp);
}
console.log(tmp);
var j;
var n = "a b c";
for (j in n) {
    console.log(n[j]);
}
// while循环
var num1 = 5;
var factorial = 1;
while (num >= 1) {
    factorial = factorial * num;
    num--;
}
console.log("5 的阶乘为：" + factorial);
