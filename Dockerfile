# FROM adoptopenjdk/maven-openjdk11 AS builder
# WORKDIR /app
# COPY . .
# RUN mvn clean install
#
# FROM adoptopenjdk/openjdk11
# RUN adduser --system --group spring
# USER spring:spring
# COPY --from=builder /app/target/*.jar app.jar
# COPY src/main/resources/application.yml application.yml
# ENTRYPOINT ["java","-jar","/app.jar", "--spring.config.location=/application.yml"]


FROM adoptopenjdk/openjdk11
RUN adduser --system --group spring
USER spring:spring
COPY target/*.jar app.jar
COPY src/main/resources/application.yml application.yml
ENTRYPOINT ["java","-jar","/app.jar", "--spring.config.location=/application.yml"]
