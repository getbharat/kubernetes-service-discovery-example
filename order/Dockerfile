FROM openjdk:11.0.2-jdk-oracle
LABEL maintainer="getbharat"
ADD target/order.jar order.jar
EXPOSE 8091 5000
ENV JAVA_OPTS="-agentlib:jdwp=server=y,transport=dt_socket,address=*:5000,suspend=n"
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar /order.jar"]