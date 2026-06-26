# AWS Microservices Project

A microservices-based architecture built with Spring Boot and integrated with AWS services. The system provides authentication, file management, and a unified API Gateway for client requests.

## Architecture

The project consists of three main microservices:

### 1. API Gateway (Port 8080)

**Technology:** Spring Cloud Gateway

**Purpose:** Single entry point for all client requests.

#### Features

* Dynamic routing to microservices
* Centralized JWT authentication and authorization
* Custom filters for token validation
* Built-in health checks

---

### 2. Auth Microservice (Port 8081)

**Technology:** Spring Boot + Spring Security

**Purpose:** Authentication and authorization management.

#### Features

* User registration and authentication
* JWT generation and validation
* Data persistence with JPA and MySQL
* Configurable roles and permissions
* RESTful endpoints for authentication operations

---

### 3. S3 Microservice

**Technology:** Spring Boot + AWS SDK

**Purpose:** File storage management using Amazon S3.

#### Features

* File upload functionality
* Native Amazon S3 integration
* Custom exception handling
* File validation

---

## Technology Stack

* **Java 17**
* **Spring Boot 3.2.4 / 4.0.3**
* **Spring Cloud 2023.0.0**
* **Spring Security**
* **Spring Data JPA**
* **MySQL**
* **AWS SDK**
* **JWT (JSON Web Token)**
* **Docker**
* **Maven**
* **Lombok**

---

## Project Structure

```text
project-microservices-aws/

├── api-gateway/
│   ├── src/main/java/com/juan/apigateway/
│   │   ├── ApiGatewayApplication.java
│   │   ├── config/
│   │   │   └── GatewayConfig.java
│   │   ├── filter/
│   │   │   └── JwtAuthenticationFilter.java
│   │   └── service/
│   │       └── JwtUtils.java
│   ├── Dockerfile
│   └── pom.xml

├── auth-microservice/
│   ├── src/main/java/com/juan/authmicroservice/
│   │   ├── AuthMicroserviceApplication.java
│   │   ├── config/
│   │   │   └── SecurityConfig.java
│   │   ├── controllers/
│   │   │   └── AuthController.java
│   │   ├── models/
│   │   │   ├── User.java
│   │   │   ├── dtos/
│   │   │   │   ├── LoginDTO.java
│   │   │   │   └── RegisterDTO.java
│   │   │   ├── enums/
│   │   │   │   └── Role.java
│   │   │   └── responses/
│   │   │       └── AuthResponse.java
│   │   ├── repos/
│   │   │   └── UserRepo.java
│   │   └── service/
│   │       ├── AuthService.java
│   │       └── JwtService.java
│   ├── Dockerfile
│   └── pom.xml

├── s3-microservice/
│   ├── src/main/java/com/juan/s3microservice/
│   │   ├── S3MicroserviceApplication.java
│   │   ├── config/
│   │   │   └── S3Config.java
│   │   ├── controllers/
│   │   │   └── StorageController.java
│   │   ├── exception/
│   │   │   ├── BusinessException.java
│   │   │   └── InfraException.java
│   │   ├── repo/
│   │   │   └── S3Repository.java
│   │   └── service/
│   │       └── StorageService.java
│   ├── Dockerfile
│   └── pom.xml

└── README.md
```

---

## Setup and Deployment

### Prerequisites

* Java 17 or higher
* Maven 3.6+
* Docker and Docker Compose
* AWS Account with Aurora configured
* AWS Account with S3 configured

---

## Environment Variables

Each microservice requires specific configuration:

### Auth Microservice

| Variable                     | Description                        |
| ---------------------------- | ---------------------------------- |
| `SPRING_DATASOURCE_URL`      | Database connection URL            |
| `SPRING_DATASOURCE_USERNAME` | Database username                  |
| `SPRING_DATASOURCE_PASSWORD` | Database password                  |
| `JWT_SECRET`                 | Secret key used for JWT generation |

### S3 Microservice

| Variable                | Description    |
| ----------------------- | -------------- |
| `AWS_ACCESS_KEY_ID`     | AWS Access Key |
| `AWS_SECRET_ACCESS_KEY` | AWS Secret Key |
| `AWS_REGION`            | AWS Region     |
| `S3_BUCKET_NAME`        | S3 Bucket Name |

### API Gateway

| Variable     | Description                                                                      |
| ------------ | -------------------------------------------------------------------------------- |
| `JWT_SECRET` | Secret key used to validate JWT tokens (must match the Auth Microservice secret) |

---

## Future Improvements

* Implement Circuit Breaker with Resilience4j
* Add monitoring using Prometheus and Grafana
* Implement centralized logging with ELK Stack
* Add automated integration tests
* Configure CI/CD pipelines
* Implement rate limiting in the API Gateway

---

## Contributing

This project follows microservices best practices and is designed to be scalable, maintainable, and cloud-ready.

---

## Author

**Juan**

## Version

**1.0.0**

## Last Updated

**2026**

