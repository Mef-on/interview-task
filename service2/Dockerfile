FROM openjdk:8-jre-alpine
ADD target/service2-*.jar /app/service2.jar
ADD src/main/resources/application.yml /app/application.yml
EXPOSE 6060
ENTRYPOINT ["java", "-Dspring.config.location=classpath:file:/app/application.yml", "-jar", "/app/service2.jar"]