# 🏦 Mesa Verde — Sistema de Gestión Bancaria y Préstamos

![Java](https://img.shields.io/badge/Java-21-007396?logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.4-6DB33F?logo=springboot&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-8-4479A1?logo=mysql&logoColor=white)
![Spring Security](https://img.shields.io/badge/Spring%20Security-JWT-6DB33F?logo=springsecurity&logoColor=white)
![License](https://img.shields.io/badge/License-Standard%20License%20Mesa%20Verde-blue)

Mesa Verde es una **API REST** para la gestión integral de operaciones bancarias: clientes, cuentas, depósitos, transferencias (intra e interbancarias) y préstamos con cuotas. Implementada con **arquitectura hexagonal (Clean Architecture)**, Spring Boot 3 y autenticación **JWT stateless**.

---

## 📋 Tabla de Contenidos

- [Características](#-características)
- [Arquitectura](#-arquitectura)
- [Tecnologías](#-tecnologías)
- [Requisitos previos](#-requisitos-previos)
- [Configuración de la Base de Datos](#-configuración-de-la-base-de-datos)
- [Configuración de la Aplicación](#-configuración-de-la-aplicación)
- [Ejecución](#-ejecución)
- [Documentación de la API](#-documentación-de-la-api)
- [Endpoints principales](#-endpoints-principales)
- [Seguridad](#-seguridad)
- [Estructura del Proyecto](#-estructura-del-proyecto)
- [Contacto](#-contacto)

---

##  Características

-  Autenticación y autorización con **JWT** (Access Token + Refresh Token)
-  Gestión de **clientes** y **usuarios** con roles
-  Registro y consulta de **bancos**
-  Manejo de **cuentas bancarias** con soporte multidivisa (PEN, USD, EUR, etc.)
-  Operaciones de **depósito**, **transferencia interna** e **interbancaria**
-  Gestión de **préstamos** con tabla de amortización (cuotas)
-  Historial de **movimientos** por cuenta con saldo antes/después
-  Documentación interactiva con **Swagger UI / OpenAPI 3**
-  Auditoría automática de creación y actualización de registros

---

## 🏛️ Arquitectura

El proyecto sigue los principios de **Clean Architecture / Arquitectura Hexagonal**, organizada en cuatro capas:

```
presentation  ──►  application  ──►  domain  ◄──  infrastructure
   (DTOs,           (Use Cases /      (Models,        (JPA Entities,
  Controllers)    ServiceImpl)      Services,        Repositories,
                                   Repositories)     Mappers, Config)
```

| Capa | Responsabilidad |
|---|---|
| `presentation` | Controladores REST, DTOs de entrada/salida |
| `application` | Implementación de casos de uso (lógica de negocio) |
| `domain` | Modelos de dominio, interfaces de servicios y repositorios |
| `infrastructure` | Entidades JPA, repositorios JPA, mappers (MapStruct), seguridad, configuración |

---

## 🛠️ Tecnologías

| Tecnología | Versión | Uso |
|---|---|---|
| Java | 21 | Lenguaje de programación |
| Spring Boot | 3.5.4 | Framework principal |
| Spring Data JPA / Hibernate | — | Persistencia |
| Spring Security | — | Seguridad y autorización |
| MySQL Connector/J | — | Driver de base de datos |
| JJWT (io.jsonwebtoken) | 0.12.6 | Generación y validación de JWT |
| MapStruct | 1.6.3 | Mapeo entre capas (Entity ↔ Model ↔ DTO) |
| Lombok | — | Reducción de código boilerplate |
| SpringDoc OpenAPI (Swagger UI) | 2.8.9 | Documentación interactiva de la API |
| HikariCP | — | Pool de conexiones (incluido en Spring Boot) |
| Maven | — | Gestión de dependencias y build |

---

## ✅ Requisitos previos

- **Java 21** o superior ([descargar](https://adoptium.net/))
- **MySQL 8** ([descargar](https://dev.mysql.com/downloads/mysql/))
- **Maven 3.9+** (o usar el wrapper incluido `./mvnw`)

---

## 🗄️ Configuración de la Base de Datos

1. Inicia tu servidor MySQL.
2. Ejecuta los scripts SQL incluidos en el siguiente orden:

```bash
# 1. Crear el esquema y las tablas
mysql -u root -p < db_mesaverde.sql

# 2. Insertar datos iniciales (roles, monedas, usuarios de prueba, etc.)
mysql -u root -p < db_mesaverde_data.sql
```

El nombre de la base de datos creada es `gestion_prestamos`.

---

## ⚙️ Configuración de la Aplicación

La configuración principal se encuentra en `src/main/resources/application.yml`.

**Variable de entorno requerida:**

| Variable | Descripción |
|---|---|
| `password` | Contraseña del usuario MySQL (`root` por defecto en local) |

Puedes definirla como variable de entorno del sistema o agregarla directamente en el archivo (no recomendado para producción):

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/gestion_prestamos?serverTimezone=America/Lima&allowPublicKeyRetrieval=true&useSSL=false
    username: root
    password: tu_contraseña_aqui   # reemplaza ${password}
```

**Configuración JWT** (editable en `application.yml`):

```yaml
security:
  jwt:
    secret: <tu_clave_secreta_base64>
    access-token-expiration: 9000000    # ms (tiempo de vida del access token)
    refresh-token-expiration: 900000    # ms (tiempo de vida del refresh token)
```

> ⚠️ **Nota:** Ajusta los valores de expiración según tus necesidades. Para producción, el refresh token debe tener una vida útil mayor que el access token.

---

## 🚀 Ejecución

### Con Maven Wrapper (recomendado)

```bash
# Linux / macOS
./mvnw spring-boot:run

# Windows
mvnw.cmd spring-boot:run
```

### Con Maven instalado

```bash
mvn spring-boot:run
```

### Generar JAR ejecutable

```bash
./mvnw clean package
java -jar target/mesaverde-0.0.1-SNAPSHOT.jar
```

La aplicación estará disponible en: **`http://localhost:8080`**

---

## 📖 Documentación de la API

Una vez que la aplicación esté en ejecución, accede a la documentación interactiva de Swagger UI:

> **`http://localhost:8080/swagger-ui/index.html`**

Desde allí puedes explorar todos los endpoints, ver los esquemas de solicitud/respuesta y probar la API directamente desde el navegador.

---

## 🌐 Endpoints principales

### 🔑 Autenticación — `/public/api/auth`

| Método | Endpoint | Descripción | Auth requerida |
|---|---|---|---|
| `POST` | `/public/api/auth/login` | Iniciar sesión, obtiene Access Token y Refresh Token | ❌ |
| `POST` | `/public/api/auth/refresh` | Renovar el Access Token usando el Refresh Token | ❌ |

**Ejemplo de login:**
```json
POST /public/api/auth/login
{
  "username": "usuario",
  "password": "contraseña"
}
```

**Respuesta:**
```json
{
  "accessToken": "eyJhbGci...",
  "refreshToken": "eyJhbGci...",
  "expiresIn": 9000
}
```

---

### 🏛️ Bancos — `/api/v1/bancos`

| Método | Endpoint | Descripción | Auth requerida |
|---|---|---|---|
| `GET` | `/api/v1/bancos/lista` | Listar todos los bancos registrados | ✅ |
| `POST` | `/api/v1/bancos/registrar` | Registrar un nuevo banco | ✅ |

---

### 👤 Clientes — `/api/v1/clientes`

| Método | Endpoint | Descripción | Auth requerida |
|---|---|---|---|
| `GET` | `/api/v1/clientes/lista` | Listar todos los clientes | ✅ |
| `POST` | `/api/v1/clientes/registrar` | Registrar un nuevo cliente | ✅ |

---

### 💳 Cuentas Bancarias — `/api/v1/cuentas`

| Método | Endpoint | Descripción | Auth requerida |
|---|---|---|---|
| `GET` | `/api/v1/cuentas/cuentas-bancarias-usuario` | Obtener las cuentas bancarias del usuario autenticado | ✅ |
| `POST` | `/api/v1/cuentas/deposito` | Realizar un depósito en una cuenta | ✅ |
| `POST` | `/api/v1/cuentas/nueva-transferencia` | Iniciar una nueva transferencia | ✅ |
| `POST` | `/api/v1/cuentas/confirmar-transferencia` | Confirmar y ejecutar una transferencia | ✅ |

---

### 📋 Préstamos — `/api/prestamos`

| Método | Endpoint | Descripción | Auth requerida |
|---|---|---|---|
| `GET` | `/api/prestamos` | Listar todos los préstamos | ✅ |

---

### 📊 Movimientos — `/api/v1/movimientos`

| Método | Endpoint | Descripción | Auth requerida |
|---|---|---|---|
| `GET` | `/api/v1/movimientos/lista` | Listar los últimos movimientos de las cuentas | ✅ |

---

## 🔒 Seguridad

La API utiliza **JWT Bearer Token** para proteger los endpoints. El flujo de autenticación es:

```
Cliente                         Servidor
  │                                 │
  │── POST /public/api/auth/login ──►│
  │◄── { accessToken, refreshToken }─│
  │                                 │
  │── GET /api/v1/... ──────────────►│
  │   Authorization: Bearer <token>  │
  │◄── 200 OK ──────────────────────│
```

- Los endpoints bajo `/public/**` son **públicos** y no requieren autenticación.
- Todos los demás endpoints requieren el header `Authorization: Bearer <accessToken>`.
- Las sesiones son **stateless** (sin almacenamiento de estado en el servidor).
- Las contraseñas se almacenan con **BCrypt**.
- CORS está habilitado y configurable en `CorsConfig.java`.

---

## 📁 Estructura del Proyecto

```
mesaverde/
├── src/
│   ├── main/
│   │   ├── java/com/cibertec/mesaverde/
│   │   │   ├── MesaverdeApplication.java          # Punto de entrada
│   │   │   ├── domain/                            # Capa de Dominio
│   │   │   │   ├── bancos/
│   │   │   │   ├── clientes/
│   │   │   │   ├── cuentas/
│   │   │   │   ├── prestamos/
│   │   │   │   ├── seguridad/
│   │   │   │   └── transacciones/
│   │   │   ├── application/                       # Casos de Uso
│   │   │   │   ├── banco/
│   │   │   │   ├── clientes/
│   │   │   │   ├── cuentas/
│   │   │   │   ├── prestamos/
│   │   │   │   ├── seguridad/
│   │   │   │   └── transacciones/
│   │   │   ├── infrastructure/                    # Infraestructura
│   │   │   │   ├── configuration/                 # Configuración (Swagger, Security, CORS, Auditoría)
│   │   │   │   ├── mapper/                        # MapStruct mappers
│   │   │   │   └── persistence/                   # Entidades JPA y repositorios
│   │   │   └── presentation/                      # Capa de Presentación
│   │   │       ├── banco/
│   │   │       ├── clientes/
│   │   │       ├── cuentas/
│   │   │       ├── prestamos/
│   │   │       ├── seguridad/
│   │   │       └── transacciones/
│   │   └── resources/
│   │       ├── application.yml                    # Configuración principal
│   │       └── i18n/messages.properties           # Mensajes internacionalizados
│   └── test/
│       └── java/com/cibertec/mesaverde/
│           └── MesaverdeApplicationTests.java
├── db_mesaverde.sql                               # Script DDL (estructura de la BD)
├── db_mesaverde_data.sql                          # Script DML (datos iniciales)
├── pom.xml                                        # Dependencias Maven
└── README.md
```

---


| | |
|---|---|
| **Proyecto** | Mesa Verde — Sistema Bancario |
| **Institución** | Cibertec |
---

<p align="center">Hecho con ❤️ usando Spring Boot · Java 21 · MySQL</p>
