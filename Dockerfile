FROM openjdk:8-jre-alpine
WORKDIR /kit
COPY ./target/apix2019-microservice-kit-java.jar /kit/app.jar
CMD ["/usr/bin/java","-jar","/kit/app.jar"]
