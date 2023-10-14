FROM openjdk:17

EXPOSE 8761

ADD target/discovery.jar discovery.jar

ENTRYPOINT ["java", "-jar", "discovery.jar"]
