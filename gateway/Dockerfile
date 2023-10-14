FROM openjdk:17

EXPOSE 8222

ADD target/gateway.jar gateway.jar

ENTRYPOINT ["java", "-jar", "gateway.jar"]
