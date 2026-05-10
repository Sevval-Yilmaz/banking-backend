# Banking Backend

## Description
RESTful backend application for managing users, bank accounts and transactions.

The project is built to practice:

* Clean Architecture principles (Domain / Application / Infrastructure separation)
* OOP design (encapsulation, aggregation, factory methods)
* Spring Boot backend development 
* PostgreSQL persistence with JPA/Hibernate 
* Containerized deployment using Docker

## Features

* User management (CRUD) 
* Bank account management
* Account creation linked to users (aggregation)
* Transaction (deposit / withdraw) 
* RESTful API design
* PostgreSQL database
* Docker & Docker Compose 
* Swagger API documentation

## Tech Stack

* Java 21
* Spring Boot
* Spring Web
* Spring Data JPA (Hibernate as ORM provider)
* PostgreSQL
* Docker & Docker Compose
* Gradle (Kotlin DSL)
* MapStruct (DTO mapping)

## Architecture
This project is evolving towards a Clean Architecture:

* Controller: HTTP requests and responses
* Service / Use Case: Application workflows
* Domain: Business logic and rules
* Repository/Infrastructure: Handles data access and persistence

## API Examples

Users:
- `GET /api/users/{id}`
- `POST /api/users`

Accounts:
- `GET /api/accounts`
- `POST /api/accounts`

Transactions:
- `POST /api/transactions`

## Run

### Option A: Local (IntelliJ)

Start PostgreSQL container first:

```bash
docker start banking-db
```

Run application:

```bash
./gradlew bootRun
```

### Option B: Docker Compose

Runs backend + database together:

```bash
docker compose up --build
```

Application runs at:

```
http://localhost:8080
```

## Swagger UI

Interactive API documentation available at:
```
http://localhost:8080/swagger-ui/index.html
```

## Database

PostgreSQL running inside Docker.

Connect via pgAdmin:

| Field    | Value       |
|----------|-------------|
| Host     | localhost   |
| Port     | 5432        |
| Database | banking     |
| Username | postgres    |

> ⚠️ Credentials are managed via `.env` file. See `.env.example`.

## Testing

API tested with Postman and Swagger UI.

## Status

Active development

## Learning Goals

This project focuses on:

* Domain-driven design basics 
* Clean Architecture patterns 
* Banking-style backend modeling 
* Real-world Spring Boot structure

## Planned Features

- JWT authentication & authorization
- Kubernetes deployment

## Author

Sevval Yilmaz

🔗 [LinkedIn](https://www.linkedin.com/in/sevval-y/)