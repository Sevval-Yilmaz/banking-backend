# 🏦 Banking Backend

## 📌 Description
RESTful backend application for managing users, bank accounts and transactions.

The project is built to practice:

* Clean Architecture principles with feature-based modular structure (user, account, transaction)
* Object-Oriented Design
* Spring Boot backend development 
* PostgreSQL persistence with JPA/Hibernate 
* Containerized deployment using Docker

## 🚀 Features

* User management (CRUD) 
* Bank account management
* Account creation linked to users
* Transaction (deposit / withdraw) 
* RESTful API design
* PostgreSQL database
* Docker & Docker Compose 
* Swagger API documentation

## 🛠 Tech Stack

* Java 21
* Spring Boot
* Spring Web
* Spring Data JPA (Hibernate as ORM provider)
* PostgreSQL
* Docker & Docker Compose
* Gradle (Kotlin DSL)
* MapStruct (DTO mapping)

## 🏗️ Architecture

> 📌 This project follows Clean Architecture principles with Domain-Driven Design (DDD) inspired modeling.

* **Controller Layer**: HTTP requests and responses
* **Application / Service Layer**: Business use cases and application workflows
* **Domain Layer**: Business logic, entities and rules
* **Infrastructure Layer**: Handles data access and persistence (JPA / PostgreSQL)

## 📡 API Examples

Users:
- `GET /api/users/{id}`
- `POST /api/users`

Accounts:
- `GET /api/accounts`
- `POST /api/accounts`

Transactions:
- `POST /api/transactions`

## ▶️ Run

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

## 📖 Swagger UI

Interactive API documentation available at:
```
http://localhost:8080/swagger-ui/index.html
```

## 🗄 Database

PostgreSQL running inside Docker.

Connect via pgAdmin:

| Field    | Value       |
|----------|-------------|
| Host     | localhost   |
| Port     | 5432        |
| Database | banking     |
| Username | postgres    |

> ⚠️ Credentials are managed via `.env` file. See `.env.example`.

## 🔧 Testing

API tested with Postman and Swagger UI.

## 📈 Status

Active development

## 🎯 Learning Goals

This project focuses on:

* Object-Oriented Programming (OOP) with strong domain modeling
* Pragmatic Domain-Driven Design (DDD-inspired design)
* Spring Boot backend development and REST API design
* Banking-style business logic modeling
* Practical, real-world project structure with feature-based organization

## 🚀 Planned Features

- JWT authentication & authorization
- Kubernetes deployment

## 👩🏻‍💻 Author

Sevval Yilmaz

🔗 [LinkedIn](https://www.linkedin.com/in/sevval-y/)