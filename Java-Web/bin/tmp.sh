#!/bin/bash


cd .. && mvn clean package && cd -

scp ./docker-compose-javaweb.yml root@114.67.240.27:/root/wei
scp ./init.sql root@114.67.240.27:/root/wei/init-scripts/
scp ../target/Java-Web-1.0-SNAPSHOT.jar root@114.67.240.27:/root/wei

ssh root@114.67.240.27 "cd /root/wei && docker build -t java-web-demo:v1.0.0 ."

ssh root@114.67.240.27 "docker rm -f mysql && docker rm -f java-web-demo && docker rm -f my-vue"

ssh root@114.67.240.27 "cd /root/wei && docker-compose -f docker-compose-javaweb.yml up -d"


ssh root@114.67.240.27
docker tag java-web-demo:v1.0.0 wwweeeiii/java-web-demo:relese-v1.0.0
docker login --username=wwweeeiii --password=Wmh123456. docker.io
docker push wwweeeiii/java-web-demo:relese-v1.0.0
docker logout

scp -r ./.tmp/vuetest/dist root@114.67.240.27:/root/wei/dist

ssh root@114.67.240.27 "cd /root/wei && rm -rf dist"
scp -r ./dist root@114.67.240.27:/root/wei/dist
scp ./nginx.conf root@114.67.240.27:/root/wei/
scp ./Dockerfile root@114.67.240.27:/root/wei/
scp ./default.conf root@114.67.240.27:/root/wei/
ssh root@114.67.240.27 "cd /root/wei && docker build -t vue-view-demo:v1.0.0 ."
ssh root@114.67.240.27 "docker rm -f my-vue && docker run --name my-vue -d -p 8888:80 vue-view-demo:v1.0.0"


docker rmi -f $(docker images -f "dangling=true" -q)



docker exec -it my-vue bash
docker exec -it my-vue ls /usr/share/nginx/html


ssh root@114.67.240.27
scp ./springboot+mysql.yml root@114.67.240.27:/root/wei/
ssh root@114.67.240.27 "cd /root/wei && kubectl delete -f springboot+mysql.yml"
ssh root@114.67.240.27 "cd /root/wei && kubectl apply -f springboot+mysql.yml"
ssh root@114.67.240.27 "cd /root/wei && kubectl delete -f springboot+mysql.yml && kubectl apply -f springboot+mysql.yml"


scp ./mysql.yml root@114.67.240.27:/root/wei/
scp ./init.sql root@114.67.240.27:/root/wei/
ssh root@114.67.240.27 "cd /root/wei && kubectl delete -f mysql.yml && kubectl apply -f mysql.yml"



mysql -h114.67.240.27 -uroot -proot

