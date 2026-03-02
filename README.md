# Mini Travel Booking API

Mini Travel Booking API is a Spring Boot based REST application that simulates a simple travel booking system.

It allows users to:
- Search travel options
- Create bookings
- Process payments
- Track booking status

The application follows a clean layered architecture and is fully containerized using Docker.
It is deployed live on Render with Swagger documentation enabled.

------------------------------------------------------------

LIVE DEPLOYMENT

Base URL:
https://mini-travel-booking.onrender.com

Swagger UI:
https://mini-travel-booking.onrender.com/swagger-ui/index.html

------------------------------------------------------------

TECH STACK

- Java 17
- Spring Boot 3
- Spring Data JPA
- H2 In-Memory Database
- Maven
- Swagger (OpenAPI 3)
- Docker
- Render (Cloud Deployment)

------------------------------------------------------------

FEATURES

- Search travel options
- Create a travel booking
- Process payment for a booking
- Automatic booking status update
- Business validation (source and destination cannot be the same)
- Input validation using Jakarta Validation
- Global exception handling
- Swagger UI for API testing
- Dockerized application
- Cloud deployment

------------------------------------------------------------

PROJECT STRUCTURE

controller  -> REST API layer
service     -> Business logic layer
repository  -> Database layer
entity      -> JPA entities
dto         -> Request/Response models
exception   -> Global exception handling

------------------------------------------------------------

API ENDPOINTS

1. Search Travel
   GET /api/search

   Required query parameters:
    - from
    - to
    - date (ISO format: YYYY-MM-DD)
    - type

   Example:
   GET /api/search?from=DELHI&to=MUMBAI&date=2026-03-10&type=FLIGHT

2. Create Booking
   POST /api/bookings

   Sample Request Body:
   {
   "userName": "Utkarsh",
   "source": "DELHI",
   "destination": "MUMBAI",
   "travelType": "FLIGHT"
   }

3. Pay for Booking
   POST /api/bookings/{bookingId}/pay

   Sample Request Body:
   {
   "paymentMethod": "UPI"
   }

------------------------------------------------------------

SAMPLE CURL COMMANDS

Search:
curl -X GET "https://mini-travel-booking.onrender.com/api/search?from=DELHI&to=MUMBAI&date=2026-03-10&type=FLIGHT"

Create Booking:
curl -X POST "https://mini-travel-booking.onrender.com/api/bookings" \
-H "Content-Type: application/json" \
-d '{"userName":"Utkarsh","source":"DELHI","destination":"MUMBAI","travelType":"FLIGHT"}'

Pay Booking:
curl -X POST "https://mini-travel-booking.onrender.com/api/bookings/{bookingId}/pay" \
-H "Content-Type: application/json" \
-d '{"paymentMethod":"UPI"}'

------------------------------------------------------------

RUNNING THE APPLICATION LOCALLY

Step 1: Build the project

./mvnw clean package

Step 2: Run the application

Run:
MiniTravelBookingApplication.java

Application URL:
http://localhost:8080

Swagger UI:
http://localhost:8080/swagger-ui/index.html

H2 Console:
http://localhost:8080/h2-console

JDBC URL:
jdbc:h2:mem:testdb

Username:
sa

Password:
(leave empty)

------------------------------------------------------------

RUNNING WITH DOCKER

Build Docker image:
docker build -t mini-travel-booking .

Run Docker container:
docker run -p 8080:8080 mini-travel-booking

------------------------------------------------------------

ARCHITECTURE HIGHLIGHTS

- Clean layered architecture
- Separation of concerns
- Business validation handled in service layer
- RESTful API design
- ISO date format (YYYY-MM-DD)
- Proper HTTP status codes
- Production-ready error handling
- GitHub to Render auto-deployment

------------------------------------------------------------

KNOWN LIMITATIONS

- Search API returns dummy travel data.
- Payment processing is simulated (no real payment gateway).
- H2 in-memory database resets data on application restart.
- Free Render instance may take time to wake up after inactivity.

------------------------------------------------------------

AUTHOR

Utkarsh Kumar Mishra