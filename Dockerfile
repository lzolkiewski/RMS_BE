FROM gradle:jdk11 AS builder
WORKDIR /home/gradle/rms
COPY --chown=gradle:gradle build.gradle settings.gradle ./
COPY --chown=gradle:gradle src/ ./src
RUN gradle build --no-daemon

FROM adoptopenjdk/openjdk11:alpine
RUN mkdir /app
COPY --from=builder /home/gradle/rms/build/libs/*.jar /app/rms.jar
EXPOSE 8080
ENTRYPOINT [ "java", "-jar", "/app/rms.jar" ]