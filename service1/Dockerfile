FROM openjdk:8-jre-alpine
ADD target/service1-*.jar service1.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "service1.jar"]