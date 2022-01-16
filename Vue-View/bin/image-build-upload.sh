#!/usr/bin/env bash

# docker build -t wwweeeii/vue-view-demo:v1.0.0 .
# docker push wwweeeiii/vue-view-demo:v1.0.0
# docker run --name my-vue -d -p 8888:80 wwweeeiii/vue-view-demo:v1.0.0
# curl http://127.0.0.1:8888/#/demo

group_name='wwweeeiii'
app_name='vue-view-demo'
app_version='v1.0.0'

build(){
  cd ../vueview
  npm install && npm run build:prod
  docker rmi ${group_name}/${app_name}:${app_version}
  docker build -t ${group_name}/${app_name}:${app_version} .
}

push(){
  docker login docker.io --username=wwweeeiii --password=Wmh123456.
  docker push ${group_name}/${app_name}:${app_version}
  docker logout docker.io
}

build
push