FROM openjdk:16
LABEL maintainer="s-f-c-m"
ADD target/clientes-0.0.1-SNAPSHOT.jar clientes-api.jar
ENTRYPOINT ["java", "-jar", "/clientes-api.jar"]
