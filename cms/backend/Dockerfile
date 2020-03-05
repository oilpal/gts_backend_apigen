FROM registry.unvus.com/unvus/unvus-jdk8:latest

ARG SPRING_PROFILE
ARG PROJECT_VERSION
ARG PROJECT_NAME

ENV PROFILE="${SPRING_PROFILE}"
ENV APP_NAME="${PROJECT_NAME}"
ENV JAVA_OPTS="-Dspring.profiles.active=${SPRING_PROFILE} -Dfile.encoding=UTF-8 -Xms512m -Xmx768m -XX:+HeapDumpOnOutOfMemoryError"

EXPOSE 8088

ADD target/gts-cms-${PROFILE}.jar /app.jar
ADD app.conf /app.conf

RUN mkdir /opt/cms-logs

RUN chown -R unvus:unvus /app.jar
RUN chown -R unvus:unvus /app.conf
RUN chown -R unvus:unvus /opt/cms-logs


USER unvus

ENTRYPOINT java -Djava.security.egd=file:/dev/./urandom -Dspring.profiles.active=${PROFILE} -Dfile.encoding=UTF-8 -jar /app.jar
