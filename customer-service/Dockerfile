FROM openjdk:17
VOLUME /tmp
EXPOSE 8080
COPY target/customerEntity-service-0.0.1-SNAPSHOT.jar customer.jar

ENTRYPOINT ["java","-jar","/customerEntity.jar"]