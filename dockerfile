FROM openjdk:19
ADD target/ExchangeRateApp-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]