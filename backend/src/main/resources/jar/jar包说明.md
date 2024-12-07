
https://chaosblade.oss-cn-hangzhou.aliyuncs.com/demo/dubbo-provider-1.0-SNAPSHOT.jar
https://chaosblade.oss-cn-hangzhou.aliyuncs.com/demo/dubbo-consumer-1.0-SNAPSHOT.jar

启动 dubbo-provider
nohup java -Djava.net.pr-eferIPv4Stack=true -Dproject.name=dubbo-provider -jar dubbo-provider-1.0-SNAPSHOT.jar > provider.nohup.log 2>&1 &

稍等 2 秒，然后启动 dubbo-consumer
nohup java -Dserver.port=8080 -Djava.net.preferIPv4Stack=true -Dproject.name=dubbo-consumer -jar dubbo-consumer-1.0-SNAPSHOT.jar > consumer.nohup.log 2>&1 &

注：根据provider的日志查看端口，不一定是8080
curl http://localhost:8080/hello?msg=world