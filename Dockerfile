FROM eclipse-temurin:21-jdk
WORKDIR /homework
COPY target/homework-0.0.1.jar .
EXPOSE 8000
ENTRYPOINT ["java", "-jar", "homework-0.0.1.jar", "--server.port=8000"]