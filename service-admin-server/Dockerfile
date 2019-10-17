FROM 150.242.235.67:5000/cloud-base/java-base:v1

# 默认编码为 UTF-8
ENV LANG C.UTF-8

ENV TIME_ZONE=Asia/Shanghai

#私有端口和公共外放端口
EXPOSE 8807:8807

WORKDIR /usr/src/app

COPY ./pom.xml /usr/src/app/logs/pom.xml



COPY ./target/service-admin-server-0.0.1-SNAPSHOT.jar /usr/src/app/service-admin-server.jar

#指令提示
ENTRYPOINT ["java","-jar","/usr/src/app/service-admin-server.jar"]