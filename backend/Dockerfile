FROM openjdk:17-jdk-slim
ADD build/libs/api-1.0.jar api-1.0.jar
ADD db.sql /docker-entrypoint-initdb.d
ENTRYPOINT ["java", "-jar", "api-1.0.jar"]