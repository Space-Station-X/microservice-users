# Etapa de construcción (builder)
FROM maven:3.9.9-amazoncorretto-17-debian-bookworm AS builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Etapa final: solo se incluye el JAR
FROM amazoncorretto:17-alpine
WORKDIR /app
COPY --from=builder /app/target/microservice-users-0.0.1-SNAPSHOT.jar microservice-users.jar
EXPOSE 8761
ENTRYPOINT ["java", "-jar", "microservice-users.jar"]
