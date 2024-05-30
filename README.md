# Vehicle Resale Platform

This is a Vehicle Resale Platform API built with Kotlin using Hexagonal Architecture. The project includes functionalities for vehicle registration, editing, listing vehicles for sale and sold, and purchasing vehicles for registered users. User authentication is managed by Auth0.

## Table of Contents
- [Prerequisites](#prerequisites)
- [Setup and Installation](#setup-and-installation)
- [Running the Application](#running-the-application)
- [API Endpoints](#api-endpoints)
- [Testing](#testing)
- [CI/CD](#cicd)
- [Technologies Used](#technologies-used)

## Prerequisites

Before you begin, ensure you have met the following requirements:
- Docker
- Docker Compose
- Java 17 (Amazon Corretto recommended)
- Gradle

## Setup and Installation

### 1. Clone the Repository
```bash
git clone <repository-url>
cd vehicle
```

### 2. Configure Environment Variables
Create a .env file in the root directory and add the following environment variables:
```bash
SPRING_PROFILES_ACTIVE=prod
SPRING_DATASOURCE_URL=jdbc:postgresql://db:5432/vehicle
SPRING_DATASOURCE_USERNAME=postgres
SPRING_DATASOURCE_PASSWORD=postgres
SPRING_JPA_HIBERNATE_DDL_AUTO=update
AUTH0_ISSUER_URI=https://dev-6uruqusryv47zcq3.us.auth0.com/
```

### 3. Build Docker Images
Build the Docker images for the application and the PostgreSQL database.
```bash
docker-compose build
```

### 4. Start the Services
Start the services using Docker Compose.
```bash
docker-compose up
```

This will start the vehicle-api service on port 8080 and the db service on port 5432.

## Running the Application
Accessing the API
Once the services are up and running, the API will be accessible at:
```bash
http://localhost:8080
```

## API Endpoints
Here are the primary endpoints provided by the API:

Vehicles
- GET /vehicles - List all vehicles for sale
- GET /vehicles/sold - List all sold vehicles
- POST /vehicles - Register a new vehicle
- PUT /vehicles/{id} - Update vehicle details
- DELETE /vehicles/{id} - Delete a vehicle

- Purchases
POST /purchases - Purchase a vehicle (authenticated users only)

- Authentication
Authentication is managed by Auth0. Ensure you have registered and obtained the necessary tokens.

## Testing
Running Tests
To run the tests, use the following command:
```bash
./gradlew test
```

## CI/CD
Continuous Integration
This project uses GitHub Actions for CI. The workflow file is located in .github/workflows/ci.yml.

Continuous Deployment
Automated deployment is configured to deploy to the production environment upon merging to the main branch. Ensure your deployment server is configured to pull the latest changes and restart the application.

## Technologies Used
- Kotlin
- Spring Boot
- PostgreSQL
- Docker
- Docker Compose
- Gradle
- Auth0
- GitHub Actions


