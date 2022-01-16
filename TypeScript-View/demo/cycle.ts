/**
 * @Author      weimenghua
 * @Date        2022-07-06 16:26
 * @Description TypeScript 循环语句
 */

// 1、for循环
// 计算 5 的阶乘， for 循环生成从 5 到 1 的数字，并计算每次循环数字的乘积。
// @ts-ignore
var num:number = 5;
var i:number;
var tmp = 1;

for (i = num; i >= 1; i--){
    tmp *= i;
    console.log(i, tmp)

}
console.log(tmp)

// 2、for...in 循环 for...in 语句用于一组值的集合或列表进行迭代输出。
var j:any;
var n:any = "a b c";
for (j in n){
    console.log(n[j])
}


// 3、while循环
var num1:number = 5;
var tmp1:number = 1;

while(num >=1) {
    tmp1 = tmp1 * num;
    num--;
}
console.log("5 的阶乘为：" + tmp1);
