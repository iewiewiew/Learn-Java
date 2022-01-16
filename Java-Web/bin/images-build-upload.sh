#!/usr/bin/env bash

# docker run -p 9999:9999 --name java-web-demo java-web-demo:v1.0.0
# 查看日志：docker logs -f java-web-demo
# 访问：http://127.0.0.1:9999/doc.html

group_name='wwweeeiii'
app_name='java-web-demo'
app_version='v1.0.0'

build(){
  cd ../
  mvn clean package
  docker rmi ${group_name}/${app_name}:${app_version}
  docker build -t ${group_name}/${app_name}:${app_version} .
}

push(){
  docker login --username=wwweeeiii --password=Wmh123456. docker.io
  docker push ${group_name}/${app_name}:${app_version}
  docker logout docker.io
}

deploy(){
  docker stop ${app_name}
  docker rm ${app_name}
  docker run -p 9999:9999 --name ${app_name} \
  --link mysql \
  -e TZ="Asia/Shanghai" \
  -v /etc/localtime:/etc/localtime \
  -v /root/wei/logs:/var/logs \
  -d ${group_name}/${app_name}:${app_version}
}

build
# push
# deploy
