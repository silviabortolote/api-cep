FROM openjdk

WORKDIR /app

COPY target/cep 0.0.1-SNAPSHOT /app/cep.jar

ENTRYPOINT ["java", "-jar", "cep.jar"]