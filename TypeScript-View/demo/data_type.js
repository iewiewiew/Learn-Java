// 1、任意类型 any 声明为 any 的变量可以赋予任意类型的值。
var x = 1;
x = "I am a string";
x = true;
console.log(x);
// 2、数字类型	number 双精度 64 位浮点值。它可以用来表示整数和分数。
var binaryLiteral = 10; // 二进制
var octalLiteral = 484; // 八进制
var decLiteral = 6; // 十进制
var hexLiteral = 0xf00d; // 十六进制
console.log(binaryLiteral, octalLiteral, decLiteral, hexLiteral);
// 3、字符串类型 string 一个字符系列，使用单引号（'）或双引号（"）来表示字符串类型。反引号（`）来定义多行文本和内嵌表达式。
var str = "我是字符串";
var num = 5;
var words = "\u5566\u5566\u5566 ".concat(str, " \u563B\u563B\u563B ").concat(num + 1, " \u54C8\u54C8\u54C8");
console.log(str, num, words);
// 4、布尔类型 boolean 表示逻辑值：true 和 false。
var flag = true;
console.log(flag);
// 5、数组类型 无 声明变量为数组。
// 在元素类型后面加上[]
var arr1 = [1, 2];
console.log(arr1);
// 或者使用数组泛型
var arr2 = [1, 2];
console.log(arr2);
// 6、元组 无 元组类型用来表示已知元素数量和类型的数组，各元素的类型不必相同，对应位置的类型需要相同。
var x1;
x1 = ['我是字符串', 1]; // 运行正常
// x1 = [1, '我是字符串'];    // 报错
console.log(x1[0]); // 输出 我是字符串
// 7、枚举 enum 枚举类型用于定义数值集合。
var Color;
(function (Color) {
    Color[Color["Red"] = 0] = "Red";
    Color[Color["Green"] = 1] = "Green";
    Color[Color["Blue"] = 2] = "Blue";
})(Color || (Color = {}));
;
var c = Color.Blue;
console.log(c); // 输出 2
// 注意：TypeScript 和 JavaScript 没有整数类型。
