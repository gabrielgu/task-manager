FROM maven:3.6.3-jdk-11 AS maven_build

COPY ./ /api-task

WORKDIR /api-task

RUN mvn clean package

FROM openjdk:11-jre-buster

COPY --from=maven_build /api-task/target/api-task-0.0.1-SNAPSHOT.jar /api-task.jar

CMD ["java", "-jar", "/api-task.jar"]
