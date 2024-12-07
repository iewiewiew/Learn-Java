import axios from 'axios'
import {Message} from 'element-ui'
// import store from '../store'
import QS from 'qs'
// import {CurrentTask} from "@/components/CurrentTask/main";

// 创建axios实例
const service = axios.create({
  baseURL: process.env.BASE_API, // api 的 base_url
  timeout: 60000,// 请求超时时间,
  /*headers: {'X-Requested-With': 'XMLHttpRequest',
    'Access-Control-Allow-Credentials': true
  },*/
  withCredentials: true
});

// request拦截器
service.interceptors.request.use(
  config => {
  if (config.method == 'get') {
  config.headers['Content-Type'] = 'application/json; charset=utf-8';
  config.url = config.url + '?' + QS.stringify(config.data);
}
return config;
},
error => {
  console.log(error);
  Promise.reject(error);
}
);

//response 拦截白名单
const RESPONSE_INTERCEPT_WHITE_LIST = ['/task/get'];

// response 拦截器
service.interceptors.response.use(
  response => {
  /**
   * code为非200是抛错
   */
  const res = response.data;
const headers = response.headers;
let tipMessage = res.message;
if (res.code == '9997' || res.code == '9998') {//需要重新登录
  tipMessage = res.msg;//提示消息
}
console.log("tipMessage:" + tipMessage);
console.log(response.data);
// url在白名单内的请求直接返回数据，不拦截
let intercept = true;
RESPONSE_INTERCEPT_WHITE_LIST.forEach(i =>{
  if(response.config.url.indexOf(i) > -1){
  intercept = false;
}
});
if(!intercept){
  return res;
}
/**
 * 判断返回header中是否存在  taskUniqueId  字段
 * 并兼容 response data中存在 taskUniqueId  字段
 */
if(headers.taskuniqueid || res.taskUniqueId){
  // CurrentTask({taskUniqueId: headers.taskuniqueid ? headers.taskuniqueid : res.taskUniqueId});
}
if (res.code !== '200') {
  //状态码，需要验证，重定向到验证页面
  if(res.code == '303'){
    Message({
      message: `前往验证验证页面`,
      type: 'info',
      duration: 1 * 1000
    });
    setTimeout(() =>{
      window.location.href = res.data;
  } , 3000);
    return;
  }
  // 50008:非法的token; 50012:其他客户端登录了;  50014:Token 过期了;
  if (res.code === '414') {
    // store.dispatch('FedLogOut').then(() => {
    //   location.reload(); // 为了重新实例化vue-router对象 避免bug
  // })
  } else if (!res.code) {
    return response.data;
  }  else {
    Message({
      message: tipMessage,
      type: 'error',
      duration: 3 * 1000
    });
  }
  return Promise.reject(res.message)
} else {
  console.log(res); //方便测试开发
  return res;
}
},
error => {
  console.log('err' + error); // for debug
  Message({
    message: error.message,
    type: 'error',
    duration: 3 * 1000
  });
  return Promise.reject(error);
}
);


export default service;
