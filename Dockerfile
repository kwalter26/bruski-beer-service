FROM openjdk:11-jre
RUN mkdir -p /usr/local/app
COPY build/libs/*.jar /usr/local/app/app.jar
WORKDIR /usr/local/app
RUN ls
CMD ["java", "-jar","app.jar"]