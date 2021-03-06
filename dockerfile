### Build app ###
FROM maven:3.6.3-adoptopenjdk-11-openj9 AS build-app
RUN mkdir /usr/src/app
COPY . /usr/src/app
WORKDIR /usr/src/app
RUN mvn clean package

### Create image ###
FROM adoptopenjdk:11-jre-openj9 as build-image
RUN mkdir /app
# Create user to mitigate some security risks
RUN addgroup --gid 1000 spring && adduser --uid 1000 --gid 1000 spring
USER spring:spring
# Run app
COPY --from=build-app /usr/src/app/target/*.jar /app/app.jar
WORKDIR /app
ENTRYPOINT ["java","-jar","app.jar"]
