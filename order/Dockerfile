FROM openjdk:11.0.2-jdk-oracle
LABEL maintainer="getbharat"
ADD target/order.jar order.jar
EXPOSE 8091:8091
ENV JAVA_OPTS=""
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar /order.jar"]