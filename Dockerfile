FROM maven:3.8.3-openjdk-17

COPY src/test/java/testNG /home/SeleniumTestFramewor/src/test/java

COPY pom.xml /home/SeleniumTestFramewor

COPY src/test/java/testNG/testng.xml /home/SeleniumTestFramewor

RUN mvn -f /home/SeleniumTestFramewor/pom.xml clean test -DskipTests=true