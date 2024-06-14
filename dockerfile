FROM maven:3.8.7 as build
COPY . .
RUN mvn package -DskipTests
# Build stage
FROM openjdk:17-jdk-slim
# Copy the packaged Spring Boot application JAR file into the container
COPY --from=build target/lending-protocol-0.0.1-SNAPSHOT.jar lending-protocol-0.0.1-SNAPSHOT.jar
# Set the working directory inside the container
# Expose the port that your Spring Boot application listens on
# Set the command to run your Spring Boot application when the container starts
CMD ["java", "-jar", "lending-protocol-0.0.1-SNAPSHOT.jar"]

