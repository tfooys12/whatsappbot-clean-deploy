# Use OpenJDK image
FROM openjdk:17-jdk-slim

# Set working directory inside container
WORKDIR /app

# Copy everything from your project into the container
COPY . .

# Build the project (you can use mvnw if you prefer)
RUN ./mvnw clean install

# Set the command to run the built JAR
CMD ["java", "-jar", "target/whatsappbot-0.0.1-SNAPSHOT.jar"]
