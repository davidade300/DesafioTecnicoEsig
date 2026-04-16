from maven:3.9-eclipse-temurin-21 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests
FROM tomcat:9.0-jdk21
COPY --from=build /app/target/sigtarefa.war /usr/local/tomcat/webapps/sigtarefa.war