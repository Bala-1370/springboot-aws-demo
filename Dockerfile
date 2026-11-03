FROM eclipse-temurin:21-jre
WORKDIR /app
COPY target/aws-demo-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT [ "java", "-Xms128m", "-Xmx384m", "-jar", "app.jar" ]