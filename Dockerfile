FROM maven:3.8.6-adoptopenjdk-17 AS builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM amazoncorretto:17-alpine-jre
WORKDIR /app
COPY --from=builder /app/target/microservice-users-0.0.1-SNAPSHOT.jar microservice-users.jar
EXPOSE 8761
ENTRYPOINT ["java", "-jar", "microservice-users.jar"]
