FROM openjdk:11
VOLUME /tmp
EXPOSE 8011
ADD ./target/customer-0.0.1-SNAPSHOT.jar customer.jar
ENTRYPOINT ["java","-jar","/customer.jar"]