#!/bin/zsh

# 后端访问：http://127.0.0.1:9999/doc.html
# 前端访问：http://127.0.0.1:8888/

start_vue(){
  stop_vue
  echo "启动前端服务"
  cd ../../Vue-View/vueview
  npm install
  npm run dev
}

stop_vue(){
  echo "停止前端服务"
  pid=`lsof -i:8888 |grep node |grep -v grep |awk '{print $2}'`
  kill -9 ${pid}
}

stop_vue
start_vue

