FROM openjdk:17-jdk as build-jar
COPY ./ ./
RUN ./mvnw clean package -P docker

FROM openjdk:17-jdk
COPY --from=build-jar ./target/*-SNAPSHOT.jar  ./app.jar
ENTRYPOINT ["java","-jar","/app.jar"]