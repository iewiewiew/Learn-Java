# 基础镜像(openjdk:8-jdk-alpine或者java:8)
FROM openjdk:8-jdk-alpine

# 作者信息
MAINTAINER "wmh 1425615649@qq.com"

# 添加存储空间
VOLUME /tmp

# 暴露端口
EXPOSE 9999

# 往容器中添加jar包
ADD ./target/Java-Web-1.0-SNAPSHOT.jar app.jar

# 启动镜像自动运行程序
ENTRYPOINT ["java", "-jar","/app.jar"]
