FROM eclipse-temurin:17-jdk-alpine
COPY target/questionService.jar .
EXPOSE 8080
ENTRYPOINT ["java","-jar","/questionService.jar"]