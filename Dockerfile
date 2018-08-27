# 基于哪个镜像
FROM java:8

RUN cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && echo 'Asia/Shanghai' >/etc/timezone

# 拷贝文件到容器，也可以直接写成ADD microservice-discovery-eureka-0.0.1-SNAPSHOT.jar /app.jar
ADD ./target/docker_maven-0.0.2-SNAPSHOT.jar /home/app.jar
# 开放8080端口
EXPOSE 8080

# 配置容器启动后执行的命令
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/home/app.jar"]