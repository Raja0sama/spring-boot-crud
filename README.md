## Overview
This is a Spring Boot application that exposes a REST API for managing a car model. The car model is stored in an H2 embedded database, which is a lightweight, in-memory database that is included with the application.

The API allows you to perform CRUD (create, read, update, delete) operations on the car model, as well as retrieve a list of all cars in the database.

### Prerequisites
- Java 8 or later
- Gradle 6.0 or later

## Running the application
To run the application, use the following command:

### Copy code
`gradle bootRun`

This will start the application and make the API available at http://localhost:8080.

### API documentation
The API is documented using Swagger. You can access the API documentation at http://localhost:8080/swagger-ui.html when the application is running.

