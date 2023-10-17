FROM openjdk:17

EXPOSE 8083

ADD target/events.jar events.jar

ENTRYPOINT ["java", "-jar", "events.jar"]
