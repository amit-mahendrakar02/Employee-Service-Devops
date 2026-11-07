# Build Satge
From maven:3.9-eclipse-temurin-21 AS build
WORKDIR /app

# Copy the pom.xml file and download the dependencies
COPY pom.xml .

# Download dependencies
RUN mvn dependency:go-offline

# Copy the source code and build the application
COPY src ./src

# Build the application and execute the tests
RUN mvn clean package -DskipTests=false

# Run Stage
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Create a non-root user and switch to it
RUN addgroup -S appgroup && adduser -S appuser -G appgroup

# Copy the built application from the build stage
COPY --from=build --chown=appuser:appgroup /app/target/*.jar app.jar

# Run the application as the non-root user
USER appuser

# Expose the application port
EXPOSE 8080

# JVM container configuration
ENV JAVA_OPTS="-XX:MaxRAMPercentage=75.0"


# Set the entry point to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]