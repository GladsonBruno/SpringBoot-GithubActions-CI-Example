FROM openjdk:17-alpine

RUN mkdir /opt/app

WORKDIR /opt/app

ADD ./target/demo-api.jar /opt/app/demo-api.jar

ENTRYPOINT ["java", "-jar", "/opt/app/demo-api.jar"]