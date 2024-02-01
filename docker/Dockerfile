FROM eclipse-temurin:19-jdk-alpine

VOLUME /tmp

COPY snapshot/ms-db-*.jar app.jar

EXPOSE 8081

CMD ["java", "-jar", "app.jar"]