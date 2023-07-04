FROM openjdk:17-alpine

RUN mkdir /opt/app

WORKDIR /opt/app

ADD ./target/springboot-api-example.jar /opt/app/springboot-api-example.jar

ENTRYPOINT ["java", "-jar", "/opt/app/springboot-api-example.jar"]