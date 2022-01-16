/**
 * @Author      weimenghua
 * @Date        2022-07-06 13:38
 * @Description TypeScript 变量声明
 */

/*
TypeScript 变量的命名规则：
变量名称可以包含数字和字母。
除了下划线 _ 和美元 $ 符号外，不能包含其他特殊字符，包括空格。
变量名不能以数字开头。
声明变量的类型及初始值：var [变量名] : [类型] = 值;
 */

// @ts-ignore
var str: string = "我是字符串";
// @ts-ignore
var num1: Number = 123;
// @ts-ignore
var num2: Number = 456;
// @ts-ignore
var num3 = num1 + num2;
console.log(str, num1, num2, num3)


/*
变量作用域指定了变量定义的位置。
程序中变量的可用性由变量作用域决定。
TypeScript 有以下几种作用域：
全局作用域 − 全局变量定义在程序结构的外部，它可以在你代码的任何位置使用。
类作用域 − 这个变量也可以称为 字段。类变量声明在一个类里头，但在类的方法外面。 该变量可以通过类的对象来访问。类变量也可以是静态的，静态的变量可以通过类名直接访问。
局部作用域 − 局部变量，局部变量只能在声明它的一个代码块（如：方法）中使用。
 */
var global_num = 1                  // 全局变量
class Numbers {
    num_val = 2;                    // 实例变量
    static static_val = 3;          // 静态变量

    storeNum():void {
        var local_num = 4;          // 局部变量
        console.log("静态变量：" + local_num)
    }
}
console.log("全局变量: " + global_num)
// @ts-ignore
var obj = new Numbers();
console.log("实例变量: " + obj.num_val)
console.log("静态变量：" + Numbers.static_val)
obj.storeNum()

