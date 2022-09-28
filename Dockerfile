FROM openjdk:11.0.12
EXPOSE 8080
ADD target/albertus-0.0.1-SNAPSHOT.jar albertus-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/albertus-0.0.1-SNAPSHOT.jar"]