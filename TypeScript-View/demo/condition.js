/**
 * @Author      weimenghua
 * @Date        2022-07-06 16:17
 * @Description TypeScript 条件语句
 */
// @ts-ignore
var num = 5;
if (num > 0) {
    console.log("num > 0");
}
else if (num < 0) {
    console.log("num < 0");
}
else {
    console.log("other");
}
// @ts-ignore
var str = "一";
switch (str) {
    case "一": {
        console.log("1");
        break;
    }
    case "二": {
        console.log("2");
        break;
    }
    case "三": {
        console.log("3");
        break;
    }
    default: {
        console.log("other");
        break;
    }
}
