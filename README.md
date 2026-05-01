# Banking Backend API

## 📌 Description

RESTful backend application for managing users and bank accounts, built to practice clean backend architecture and core Spring Boot concepts.

## 🚀 Features

* User and account management (User & Account API)
* Linking users and accounts
* RESTful API design
* H2 in-memory database
* API testing with Postman

## 🛠️ Tech Stack

* Kotlin
* Spring Boot
* Spring Web
* Spring Data JPA
* Hibernate
* H2 Database
* Gradle (Kotlin DSL)

## 🏗️ Architecture

Layered architecture:

* Controller: HTTP layer
* Service: Business logic
* Repository: Data access

## 🔗 API Examples

* GET /users/{id}
* POST /users
* GET /accounts/{id}
* POST /accounts

## ▶️ Run

```bash
./gradlew bootRun
```

App runs at:

```
http://localhost:8080
```

## 🧪 Testing

API tested with Postman.

## 🗄️ Database

H2 in-memory database
Console: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)

## 📈 Status

Active development

## ⚙️ Planned Features

* Transfers between accounts
* JWT authentication & authorization
* PostgreSQL integration

---

## 👩🏻‍💻 Author

Sevval Yilmaz

🔗 [LinkedIn](https://www.linkedin.com/in/sevval-y/)
