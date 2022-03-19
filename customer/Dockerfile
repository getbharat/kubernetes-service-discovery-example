FROM openjdk:11-jdk
LABEL maintainer="getbarat"
ADD target/customer.jar customer.jar
EXPOSE 8090
ENV JAVA_OPTS=""
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar /customer.jar"]