FROM openjdk:11-jdk-alpine
#FROM adoptopenjdk/openjdk11:alpine-jre
#RUN addgroup -S spring && adduser -S spring -G spring
#USER spring:spring
VOLUME /tmp
ARG JAR_FILE=target/spring-customer-redis.jar
#COPY ${JAR_FILE} spring-customer-redis.jar
ADD ${JAR_FILE} spring-customer-redis.jar
ENTRYPOINT ["java","-jar","/spring-customer-redis.jar"]
#EXPOSE 2222
EXPOSE 9292