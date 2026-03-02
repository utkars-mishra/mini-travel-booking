# Mini Travel Booking API

This is a simple backend REST API built using Spring Boot.  
The project simulates a basic travel booking system where users can create bookings, process payments, and track booking status.

The application is fully containerized using Docker and includes Swagger documentation for API testing.

---

## Tech Stack

- Java 17
- Spring Boot 3
- Spring Data JPA
- H2 In-Memory Database
- Swagger (OpenAPI)
- Maven
- Docker

---

## Features

- Create a travel booking
- Process payment for a booking
- Automatically update booking status
- Global exception handling
- Input validation
- Swagger UI for API testing
- Dockerized deployment

---

## Project Structure

controller → Handles API requests  
service → Business logic  
repository → Database layer  
entity → JPA entities  
dto → Request/Response models  
exception → Global exception handler

---

## Running the Application Locally

### Step 1: Build the project

Use Maven lifecycle in IntelliJ:

Lifecycle → clean  
Lifecycle → package

Or run:
./mvnw clean package


---

### Step 2: Run the application

Click the Run button on:

MiniTravelBookingApplication.java

Application runs at:
http://localhost:8080


Swagger UI:
http://localhost:8080/swagger-ui.html


H2 Console:
http://localhost:8080/h2-console


JDBC URL:
jdbc:h2:mem:testdb

Username:
sa


Password:
(leave empty)

---

## Running with Docker

### Step 1: Build Docker image
docker build -t mini-travel-booking .


### Step 2: Run Docker container
docker run -p 8080:8080 mini-travel-booking


---

## API Endpoints

POST /api/bookings → Create booking  
POST /api/payments → Process payment  
GET /api/bookings/{id} → Get booking details

---

## Author

Utkarsh Kumar Mishra

