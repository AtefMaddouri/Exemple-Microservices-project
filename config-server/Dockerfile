# Use an OpenJDK Runtime as a parent image
FROM openjdk:17-jdk-slim
# Add Maintainer Info
LABEL maintainer="atef.maddouri@esprit.tn"
# Set the working directory to /app
#WORKDIR /app
# Copy the executable into the container at /app
ADD target/*.jar app.jar
# Make port 8080 available to the world outside this container
EXPOSE 8761
# Run app.jar when the container launches
CMD ["java", "-jar", "app.jar"]