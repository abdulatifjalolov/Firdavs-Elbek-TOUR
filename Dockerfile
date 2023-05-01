FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY target/* app.jar
ADD target/spring-ci-cd-new.jar spring-ci-cd-new.jar
ENTRYPOINT ["java","-jar","app.jar"]
EXPOSE 8080
