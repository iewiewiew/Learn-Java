### Docker安装Jenkins
```
docker search jenkins                   #搜索jenkins
docker pull jenkins/jenkins             #拉取jenkins
mkdir -p /usr/local/docker/jenkins      #创建挂载目录
chmod 777 /usr/local/docker/jenkins     #分配权限

docker run -d \
    -u root \
    -p 8888:8080 \
    -p 50000:50000 \
    -v /usr/local/docker/jenkins:/var/jenkins_home \
    -v /etc/localtime:/etc/localtime \
    --restart=always \
    --name=jenkins \
    jenkins/jenkins
    
-d：后台运行容器；
-p 8888:8080：将容器的 8080 端口映射到服务器的 8888 端口；
-p 50000:50000：将容器的 50000 端口映射到服务器的 50000 端口；
-v /usr/local/docker/jenkins:/var/jenkins_home：将容器中 Jenkins 的工作目录挂载到服务器的 /usr/local/docker/jenkins；
-v /etc/localtime:/etc/localtime：让容器使用和服务器同样的时间设置；
--restart=always：设置容器的重启策略为 Docker 重启时自动重启；
--name=jenkins：给容器起别名；

docker ps -l                    #验证是否运行成功
docker logs jenkins             #查看启动日志
http://127.0.0.1:8888/          #验证 http://192.168.0.4:8888/
docker ps                       #查看docker的<容器ID>
docker exec -it <容器ID> bash    #进入容器
docker exec -it jenkins bash    #进入容器
cat /var/jenkins_home/secrets/initialAdminPassword      #Jenkins初始密码：4683c6e276df45c3a2e2b60801eb904f
admin admin                     #账号密码
```