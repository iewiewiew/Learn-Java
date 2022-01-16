/**
 * @Author      weimenghua
 * @Date        2022-07-06 13:38
 * @Description TypeScript 面向对象
 */

class Demo {
    num_val: string;
    storeNum() {
        throw new Error("Method not implemented.");
    }
    func():void{
        console.log("学习TypeScript面向对象")
    }
}
var obj = new Demo();
obj.func()
