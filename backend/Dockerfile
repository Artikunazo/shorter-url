FROM openjdk:17-jdk-slim
ADD build/libs/shorter-url-1.0.jar shorter-url-1.0.jar
ADD db.sql /docker-entrypoint-initdb.d
ENTRYPOINT ["java", "-jar", "shorter-url-1.0.jar"]