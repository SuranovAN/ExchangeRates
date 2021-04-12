FROM openjdk:11
EXPOSE 8080
ADD /target/ExchangeRates-0.0.1-SNAPSHOT.jar exchangeRates.jar
ENTRYPOINT ["java", "-jar", "exchangeRates.jar"]