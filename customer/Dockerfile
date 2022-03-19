FROM openjdk:11-jdk
LABEL maintainer="getbarat"
ADD target/customer.jar customer.jar
EXPOSE 8090 8000
ENV JAVA_OPTS="-agentlib:jdwp=server=y,transport=dt_socket,address=*:8000,suspend=n"
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar /customer.jar"]