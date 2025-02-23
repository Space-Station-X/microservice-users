FROM amazoncorretto:17-alpine-jdk
WORKDIR /app
EXPOSE 8761
ADD ./target/eureka-users-0.0.1-SNAPSHOT.jar microservice-users.jar
ENTRYPOINT ["java", "-jar", "microservice-users.jar"]
