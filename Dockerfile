FROM openjdk:11

EXPOSE 8080

ADD build/libs/calculator-0.0.1-SNAPSHOT.jar calculator-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "calculator-0.0.1-SNAPSHOT.jar"]