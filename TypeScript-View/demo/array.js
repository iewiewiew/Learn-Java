/**
 *@author       weimenghua
 *@time         2022-07-12 13:40
 *@description  Array(数组) 数组对象是使用单独的变量名来存储一系列的值。
 */
var arr;
arr = ["呱", "呱", "大", "王"];
console.log(arr[0]);
console.log(arr[1]);
console.log(arr[2]);
console.log(arr[3]);
var arr_1 = new Array("呱", "呱", "大", "王");
for (var i = 0; i < arr_1.length; i++) {
    console.log(arr_1[i]);
}
var arr_2 = new Array(4);
for (var i = 0; i < arr_2.length; i++) {
    arr_2[i] = i * 2;
    console.log(arr_2[i]);
}
// 数组解构 （解构是什么意思？）
var arr_3 = [12, 13];
var x11 = arr_3[0], y11 = arr_3[1]; // 将数组的两个元素赋值给变量 x 和 y
console.log(x11);
console.log(y11);
// 数组迭代
var j;
var nums = [1001, 1002, 1003, 1004];
for (j in nums) {
    console.log(nums[j]);
}
// 多维数组
var multi = [[1, 2, 3], [23, 24, 25]];
console.log(multi[0][0]);
console.log(multi[0][1]);
console.log(multi[0][2]);
console.log(multi[1][0]);
console.log(multi[1][1]);
console.log(multi[1][2]);
