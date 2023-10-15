FROM ubuntu:latest AS BUILD

RUN apt-get-update
RUN apt-get install openjdk-17 -y

COPY . .

RUN apt-get install maven -y

RUN mvn clean install

EXPOSE 8080

COPY --from=build /target/todolist-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT [ "java", "-jar", "äpp.jar" ]