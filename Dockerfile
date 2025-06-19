# Use an OpenJDK base image with Maven preinstalled
FROM maven:3.9.5-eclipse-temurin-17

# Set the working directory inside the container
WORKDIR /app

# Copy everything from your project folder into the container
COPY . .

# Build the project using system Maven
RUN mvn clean install

# Set the command to run the built jar
CMD ["java", "-jar", "target/whatsappbot-0.0.1-SNAPSHOT.jar"]

