var Demo = /** @class */ (function () {
    function Demo() {
    }
    Demo.prototype.func = function () {
        console.log("学习TypeScript面向对象");
    };
    return Demo;
}());
var obj = new Demo();
obj.func();
