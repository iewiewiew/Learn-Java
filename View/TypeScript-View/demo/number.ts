/**
 *@author          weimenghua
 *@time            2022-07-12 11:58
 *@description     Number 对象是原始数值的包装对象。
 */

function people(id:number, name:string){
    this.id = id
    this.name = name
}

var peo = new people(666, "呱呱大王")
people.prototype.email = "123@qq.com"

console.log("编号：" + peo.id)
console.log("姓名：" + peo.name)
console.log("邮箱：" + peo.email)

var num1 = 123.456
console.log("把对象的值转换为指数计数法：" + num1.toExponential())
console.log("把数字转换为字符串，并对小数点指定位数：" + num1.toFixed(9))
console.log("把数字转换为字符串，使用本地数字格式顺序：" + num1.toLocaleString())
console.log("把数字格式化为指定的长度：" + num1.toPrecision(6))
console.log("把数字转换为字符串，使用指定的基数。数字的基数是 2 ~ 36 之间的整数。若省略该参数，则使用基数 10：" + num1.toString())
console.log("返回一个 Number 对象的原始数字值：" + num1.valueOf())