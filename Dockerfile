FROM openjdk:latest
COPY ./target/grp1-1.0-SNAPSHOT-jar-with-dependencies.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "grp1-1.0-SNAPSHOT-jar-with-dependencies.jar"]