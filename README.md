# PaymentServiceJan25

A Java Spring Boot microservice for handling payment initiation and integration with multiple payment gateways (Razorpay, Stripe). Designed as part of a scalable backend microservices architecture.

## Overview
This service exposes RESTful endpoints to initiate payments for orders, supporting integration with payment gateways like Razorpay and Stripe. It is intended to be used as a backend component in a larger system (e.g., e-commerce, booking platforms).

## Architecture
- **Spring Boot** application
- **Controller**: Handles HTTP requests (`PaymentController`)
- **Service**: Business logic for payment initiation (`PaymentService`)
- **Payment Gateway Integrations**: Pluggable gateway implementations (`RazorpayPaymentGateway`, `StripePaymentGateway`)
- **DTOs**: Data Transfer Objects for request/response payloads

### Directory Structure
```
src/main/java/com/scaler/paymentservicejan25/
├── controllers/         # REST controllers
├── services/            # Business logic
├── paymentgateway/      # Payment gateway interfaces & implementations
├── dtos/                # Data Transfer Objects
├── repositories/        # (empty, for future data access)
└── PaymentServiceJan25Application.java  # Main entry point
```

## API Endpoints
### Initiate Payment
- **POST** `/payments/initiate/{orderId}`
  - **Path Variable:** `orderId` (Long)
  - **Request Param:** `phoneNumber` (String)
  - **Response:** Short URL for payment (from gateway)

#### Example Request
```
POST /payments/initiate/12345?phoneNumber=9876543210
```
#### Example Response
```
https://rzp.io/i/short-url
```

## Environment Variables & Configuration
Configuration is managed via `src/main/resources/application.properties`:
```
spring.application.name=PaymentServiceJan25
razorpay.keyId=${RAZORPAY_KEY_ID}
razorpay.keySecret=${RAZORPAY_KEY_SECRET}
```
Set the following environment variables in your deployment environment:
- `RAZORPAY_KEY_ID`: Your Razorpay API key ID
- `RAZORPAY_KEY_SECRET`: Your Razorpay API key secret

## Payment Gateway Integration
- **Razorpay**: Default gateway (see `RazorpayPaymentGateway`). Uses API keys from environment variables. Generates a payment link and returns the short URL.
- **Stripe**: Example stub implementation (`StripePaymentGateway`).
- **Extensibility**: Add new gateways by implementing the `PaymentGateway` interface.

## Running Locally
1. Clone the repository.
2. Set environment variables for Razorpay credentials.
3. Build and run the Spring Boot application:
   ```sh
   ./mvnw spring-boot:run
   ```
4. The service will be available at `http://localhost:8080` by default.

## Testing
- Basic context load test is provided in `PaymentServiceJan25ApplicationTests`.
- Extend with integration and unit tests as needed.

## Future Improvements
- Add persistent storage and repositories for payment/order tracking.
- Implement webhook/callback handling for payment status updates.
- Add authentication and authorization for endpoints.
- Expand test coverage.

---
© Scaler, 2024. For internal use and educational purposes. 