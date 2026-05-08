# Banking Backend

## 📌 Description
RESTful backend application for managing users and bank accounts, built to practice clean backend architecture, core Spring Boot concepts, and containerized deployment with Docker.

## 🚀 Features

* User and account management (User & Account API)
* Linking users and accounts
* Transaction support 
* RESTful API design
* PostgreSQL database
* Containerized with Docker & Docker Compose 
* API documentation with Swagger UI

## 🛠️ Tech Stack

* Java 21
* Spring Boot
* Spring Web
* Spring Data JPA (Hibernate as ORM provider)
* PostgreSQL
* Docker & Docker Compose
* Gradle (Kotlin DSL)

## 🏗️ Architecture
Layered architecture:

* Controller: HTTP layer
* Service: Business logic
* Repository: Data access

## 🔗 API Examples

- `GET /api/users/{id}`
- `POST /api/users`
- `GET /api/accounts/{id}`
- `POST /api/accounts`

## ▶️ Run

### Option A: Local (IntelliJ)

Make sure the PostgreSQL container is running first:

```bash
docker start banking-db
```

Then start the app:

```bash
./gradlew bootRun
```

### Option B: Docker Compose

Starts both the app and the database together:

```bash
docker compose up --build
```

App runs at:
```
http://localhost:8080
```

## 📖 Swagger UI

Interactive API documentation available at:
```
http://localhost:8080/swagger-ui/index.html
```

## 🗄️ Database

PostgreSQL running in Docker.

To inspect the database, connect via pgAdmin 4:

| Field    | Value       |
|----------|-------------|
| Host     | localhost   |
| Port     | 5432        |
| Database | banking     |
| Username | postgres    |

> ⚠️ Credentials are managed via `.env` file. See `.env.example` for required variables.

## 🧪 Testing

API tested with Postman and Swagger UI.

## 📈 Status

Active development

## ⚙️ Planned Features

- JWT authentication & authorization
- Kubernetes deployment

## 👩🏻‍💻 Author

Sevval Yilmaz

🔗 [LinkedIn](https://www.linkedin.com/in/sevval-y/)