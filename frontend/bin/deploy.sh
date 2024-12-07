#!/usr/bin/env bash

# docker build -t wwweeeii/vue-view-demo:v1.0.0 .
# docker push wwweeeiii/vue-view-demo:v1.0.0
# docker run --name my-vue -d -p 8888:80 wwweeeiii/vue-view-demo:v1.0.0
# curl http://127.0.0.1:8888/#/demo

group_name='wwweeeiii'
app_name='vue-view-demo'
app_version='v1.0.0'

docker rm -f my-vue
docker run --name my-vue -d -p 8888:80 ${group_name}/${app_name}:${app_version}

