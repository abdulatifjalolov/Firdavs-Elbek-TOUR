FROM openjdk:17-alpine
ADD target/Firdavs-Elbek-TOUR-0.0.1-SNAPSHOT.jar Firdavs-Elbek-TOUR-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","Firdavs-Elbek-TOUR-0.0.1-SNAPSHOT.jar"]