FROM openjdk:8-jdk-alpine

ADD hw-0.0.1-SNAPSHOT.jar hw-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/hw-0.0.1-SNAPSHOT.jar"]