# Verdolaga Nation - README

Este repositorio contiene el código para la aplicación de Verdolaga Nation, una red social diseñada para interactuar con otros usuarios, publicar contenido, gestionar un perfil, y más. Este proyecto está dividido en dos partes: el **Backend** (Spring Boot) y el **Frontend** (React con Vite).

## Tabla de Contenidos
- [Backend](#backend)
  - [Requisitos](#requisitos-backend)
  - [Instalación y Configuración](#instalación-y-configuración-backend)
  - [API Endpoints](#api-endpoints-backend)
- [Frontend](#frontend)
  - [Requisitos](#requisitos-frontend)
  - [Instalación y Configuración](#instalación-y-configuración-frontend)
  - [Scripts de Desarrollo](#scripts-de-desarrollo)
- [Contribuir](#contribuir)
- [Licencia](#licencia)

---

## Backend

### Requisitos Backend
- Java 17+
- Maven
- MySQL (o cualquier base de datos compatible con Spring Boot)
- Postman (opcional para probar las API)

### Instalación y Configuración Backend

1. **Clonar el repositorio:**

   ```bash
   git clone https://github.com/usuario/verdolaga-nation.git
   cd verdolaga-nation
   ```
2. **Configuración de la base de datos:**

Asegúrate de tener MySQL instalado y ejecutándose en tu máquina.
Crea una base de datos llamada verdolaga_nation (o cambia el nombre de la base de datos en el archivo application.properties).

```sql
CREATE DATABASE verdolaga_nation;
```
3. **Configura las credenciales de la base de datos:**
En src/main/resources/application.properties, ajusta las credenciales de tu base de datos:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/verdolaga_nation
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update
```

4. **Compilar y ejecutar el servidor backend:**

Navega hasta la carpeta del backend y ejecuta:
```bash
mvn clean install
mvn spring-boot:run
```
El backend debería iniciarse en http://localhost:8080.

5. **API Endpoints Backend**
- **Registro de usuario**: `POST /auth/register`
- **Inicio de sesión**: `POST /auth/login`
- **Obtener perfil de usuario**: `GET /users/find`
- **Obtener publicaciones**: `GET /publications/find`
- **Crear publicación**: `POST /publications/post`


## Enlace al repositorio del frontend

El frontend de este proyecto está disponible en el siguiente repositorio:

➡️ [Verdolaga Nation - Frontend](https://github.com/juanconde025/verdolaga_nation_front)

## Documentación en Swagger 

El proyecto consta de documentación en Swagger para ver sus endponits y sus utilidades

➡️ [Swagger - Verdolaga Nation](http://localhost:8080/swagger-ui.html)
