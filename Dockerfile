FROM maven:latest

LABEL authors="willi"

WORKDIR /app

COPY pom.xml /app/

COPY . /app/

RUN mvn package

CMD ["java", "-jar", "target/tripcalaculator.jar"]