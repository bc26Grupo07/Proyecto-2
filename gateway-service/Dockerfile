FROM openjdk:11.0-oracle
COPY "./target/gateway-service-0.0.1-SNAPSHOT.jar" "config-service.jar"
#EXPOSE 8081
ENTRYPOINT ["java", "-jar","gateway-service.jar"]