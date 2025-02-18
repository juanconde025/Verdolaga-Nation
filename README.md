# Verdolaga Nation - README

This repository contains the code for the Verdolaga Nation application, a social network designed to interact with other users, post content, manage a profile, and more. This project is divided into two parts: the Backend (Spring Boot) and the Frontend (React with Vite).

## Table of Contents
- [Backend](#backend)
  - [Requirements](#requisitos-backend)
  - [Installation and Configuration](#instalación-y-configuración-backend)
  - [API Endpoints](#api-endpoints-backend)
- [Frontend](#frontend)
  - [Requirements](#requisitos-frontend)
  - [Installation and Configuration](#instalación-y-configuración-frontend)
  - [Development Scripts](#scripts-de-desarrollo)
- [Contribute](#contribuir)
- [License](#licencia)

---

## Backend

### Backend Requirements
- Java 17+
- Maven
- MySQL (or any database compatible with Spring Boot)
- Postman (optional for testing APIs)

### Backend Installation and Configuration

1. **Clone the repository:**

   ```bash
   git clone https://github.com/usuario/verdolaga-nation.git
   cd verdolaga-nation
   ```
2. **Database setup:**
Ensure you have MySQL installed and running on your machine.
Create a database named verdolaga_nation (or change the database name in the application.properties file).

```sql
CREATE DATABASE verdolaga_nation;
```
3. **Configure database credentials:**
In src/main/resources/application.properties, adjust your database credentials:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/verdolaga_nation
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update
```

4. **Compile and run the backend server:**
Navigate to the backend folder and run:
```bash
mvn clean install
mvn spring-boot:run
```
The backend should start at http://localhost:8080.

5. **API Endpoints Backend**
- **User registration**: `POST /auth/register`
- **User login**: `POST /auth/login`
- **Get user profile**: `GET /users/find`
- **Get posts**: `GET /publications/find`
- **Create post**: `POST /publications/post`


## Link to the Frontend Repository

The frontend for this project is available in the following repository:

➡️ [Verdolaga Nation - Frontend](https://github.com/juanconde025/verdolaga_nation_front)

## Swagger Documentation

The project includes Swagger documentation to view its endpoints and their functionalities:

➡️ [Swagger - Verdolaga Nation](http://localhost:8080/swagger-ui.html)
