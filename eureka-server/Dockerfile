FROM openjdk:8
VOLUME /tmp
EXPOSE 8761
ARG JAR_FILE=target/eureka-server-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} eureka-server.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/ ./urandom","-jar","/eureka-server.jar"]
