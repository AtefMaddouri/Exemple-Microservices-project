# Use an OpenJDK Runtime as a parent image
FROM openjdk:8-jre-alpine
# Add Maintainer Info
LABEL maintainer="atef.maddouri@esprit.tn"
# Set the working directory to /app
WORKDIR /app
# Copy the executable into the container at /app
ADD target/*.jar app.jar
# Make port 9093 available to the world outside this container
EXPOSE 9093
# Run app.jar when the container launches
CMD ["java", "-jar", "/app/app.jar"]