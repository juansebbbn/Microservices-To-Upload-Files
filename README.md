# Proyecto de Microservicios + AWS

Este proyecto implementa una arquitectura de microservicios basada en Spring Boot con integración con servicios de AWS. El sistema está diseñado para proporcionar autenticación, gestión de archivos y una puerta de enlace API unificada.

##  Arquitectura

El proyecto consta de tres microservicios principales:

### 1. API Gateway (Puerto 8080)
- **Tecnología**: Spring Cloud Gateway
- **Función**: Punto de entrada único para todas las solicitudes del cliente
- **Características**:
  - Enrutamiento dinámico a microservicios
  - Autenticación y autorización centralizada con JWT
  - Filtros personalizados para validación de tokens
  - Health checks integrados

### 2. Auth Microservice (Puerto 8081)
- **Tecnología**: Spring Boot con Spring Security
- **Función**: Gestión de autenticación y autorización
- **Características**:
  - Registro y autenticación de usuarios
  - Generación y validación de tokens JWT
  - Persistencia con JPA y MySQL
  - Roles y permisos configurables
  - Endpoints RESTful para operaciones de autenticación

### 3. S3 Microservice
- **Tecnología**: Spring Boot con AWS SDK
- **Función**: Gestión de almacenamiento de archivos en AWS S3
- **Características**:
  - Subida de archivos
  - Integración nativa con Amazon S3
  - Manejo de excepciones personalizado
  - Validación de archivos

## 🛠️ Stack Tecnológico

- **Java**: 17
- **Spring Boot**: 3.2.4 / 4.0.3
- **Spring Cloud**: 2023.0.0
- **Spring Security**: Para autenticación y autorización
- **Spring Data JPA**: Para persistencia de datos
- **MySQL**: Base de datos relacional
- **AWS SDK**: Para integración con servicios de Amazon
- **JWT**: Para tokens de autenticación
- **Docker**: Para contenerización
- **Maven**: Para gestión de dependencias
- **Lombok**: Para reducir código repetitivo

##  Estructura del Proyecto

```
proyecto-microservicios-aws/
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

## 🚀 Configuración y Despliegue

### Prerrequisitos
- Java 17 o superior
- Maven 3.6+
- Docker y Docker Compose
- Cuenta de AWS con Aurora configurado
- Cuenta de AWS con S3 configurado

### Variables de Entorno

Cada microservicio requiere configuración específica:

#### Auth Microservice
- `SPRING_DATASOURCE_URL`: URL de conexión a MySQL
- `SPRING_DATASOURCE_USERNAME`: Usuario de base de datos
- `SPRING_DATASOURCE_PASSWORD`: Contraseña de base de datos
- `JWT_SECRET`: Clave secreta para JWT

#### S3 Microservice
- `AWS_ACCESS_KEY_ID`: Access key de AWS
- `AWS_SECRET_ACCESS_KEY`: Secret key de AWS
- `AWS_REGION`: Región de AWS
- `S3_BUCKET_NAME`: Nombre del bucket S3

#### API Gateway
- `JWT_SECRET`: Clave secreta para validación de JWT (debe coincidir con auth-microservice)

## 🔄 Próximos Pasos

- Implementar circuit breaker con Resilience4j
- Agregar monitoring con Prometheus y Grafana
- Implementar logging centralizado con ELK Stack
- Agregar tests de integración automatizados
- Configurar CI/CD pipeline
- Implementar rate limiting en el API Gateway

##  Contribución

Este proyecto sigue las mejores prácticas de desarrollo de microservicios y está diseñado para ser escalable y mantenible.

---

**Autor**: Juan  
**Versión**: 1.0.0  
**Última actualización**: 2026
