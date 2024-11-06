# Start with an official OpenJDK image as a base
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the built JAR file to the container
COPY target/daytracking-0.0.1-SNAPSHOT.jar daytrack.jar

# Expose the port that your Spring Boot app runs on
EXPOSE 8080

# Run the JAR file
ENTRYPOINT ["java", "-jar", "daytrack.jar"]
