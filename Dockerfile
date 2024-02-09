FROM openjdk:latest
COPY ./target/grp1.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "grp1.jar", "db:3306", "30000"]