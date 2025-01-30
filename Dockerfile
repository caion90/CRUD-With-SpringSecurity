# Step 1: Choose a base image
FROM openjdk:17-jdk-slim

# Step 2: Set the working directory
WORKDIR /usr/src/app

# Step 3: Copy the necessary files
COPY . .

# Step 4: Install dependencies and build the application
RUN ./mvnw package

# Step 5: Expose the required port
EXPOSE 8080

# Step 6: Define the command to run the application
CMD ["java", "-jar", "target/demo-0.0.1-SNAPSHOT.jar"]
