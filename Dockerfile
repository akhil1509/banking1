FROM openjdk:17-alpine
EXPOSE 8081
ADD target/banking-0.0.1-SNAPSHOT.jar banking-0.0.1-SNAPSHOT.jar
ENTRYPOINT [ "java","-jar","/banking-0.0.1-SNAPSHOT.jar"]
