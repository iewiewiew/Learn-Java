#!/bin/zsh

# 后端访问：http://127.0.0.1:9999/doc.html
# 前端访问：http://127.0.0.1:8888/

start_javaweb(){
  stop_javaweb
  echo "启动后端服务"
  cd ../backend
  mvn clean package
  cd ./target
  java -jar backend-1.0-SNAPSHOT.jar
}

stop_javaweb(){
  echo "停止后端服务"
  pid=`ps -ef|grep backend |grep -v grep |awk '{print $2}'`
  kill -9 ${pid}
}

start_javaweb

