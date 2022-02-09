FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean -B package -Dmaven.test.skip=true -Dmaven.artifact.threads=10

# Package stage
FROM openjdk:11-jre-slim AS package
#FORM openjdk:17-ea-22-jdk-oracle AS Package
COPY --from=build /home/app/target/*.jar /usr/local/lib/app.jar
# COPY ./public  /usr/local/lib/public
EXPOSE 80
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/usr/local/lib/app.jar"]