/**
 *@author       weimenghua
 *@time         2022-07-14 12:47
 *@description  Buffer 缓冲区
 */

const buf = Buffer.from('呱呱大王', 'ascii');

// 输出 72756e6f6f62
console.log(buf.toString('hex'));

// 输出 cnVub29i
console.log(buf.toString('base64'));