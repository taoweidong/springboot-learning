FROM java:8
VOLUME /tmp
ADD /target/SpringBoot-Thymeleaf-0.0.1-SNAPSHOT.jar app.jar
RUN bash -c 'touch ./app.jar'
EXPOSE 8090
ENTRYPOINT ["java","-jar","/app.jar"]