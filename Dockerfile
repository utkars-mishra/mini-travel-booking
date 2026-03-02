#  Java image
FROM eclipse-temurin:17-jdk-alpine

# Setting working directory inside container
WORKDIR /app

# Copy building jar file into container
COPY target/mini-travel-booking-0.0.1-SNAPSHOT.jar app.jar

# Exposing port 8080
EXPOSE 8080

# Run the jar
ENTRYPOINT ["java", "-jar", "app.jar"]