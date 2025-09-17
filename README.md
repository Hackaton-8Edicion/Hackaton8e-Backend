# 💊 Medication Reminder - RESTful API

A RESTful API designed to manage medications, schedules, and daily intake tracking.  
This backend provides a secure and scalable system that helps users keep track of their prescriptions and receive reminders.

![Java](https://img.shields.io/badge/Java-21-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.4-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![Spring Security](https://img.shields.io/badge/Spring%20Security-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white)
![GitHub Actions](https://img.shields.io/badge/GitHub%20Actions-2088FF?style=for-the-badge&logo=github-actions&logoColor=white)

---

## 📋 Table of Contents
- [🎯 Project Overview](#project-overview)
- [✨ Features](#features)
- [🚀 Getting Started](#getting-started)
- [⚙️ Installation](#installation)
- [🏃 Running the Application](#running-the-application)
- [🌐 API Endpoints](#api-endpoints)
- [🔧 Technologies](#technologies)
- [📊 Architecture](#architecture)
- [🧪 Tests](#tests)
- [🔄 Automation](#automation)
- [🤝 Contributing](#contributing)
- [👩‍💻 Authors](#authors)

---

## 🎯 Project Overview
Managing medication routines is a daily challenge. Users often rely on fragmented reminders or manual tracking, which can result in missed doses.

**Medication Reminder API** addresses this problem by providing:
- Secure authentication and user accounts.
- A system to register medications and schedules.
- Endpoints to log daily intakes.
- Dashboard data to check compliance and upcoming doses.

---

## ✨ Features
- 👤 User registration & login with **JWT authentication**.
- 💊 CRUD operations for medications.
- ⏰ Schedule management (daily/weekly routines).
- ✅ Track whether medication was taken or missed.
- 📊 Dashboard endpoint to view today’s doses.
- 🔒 Role-based access (future enhancement: Admin/User separation).

**Future Enhancements**
- 🔔 Push notifications & reminders.
- 📈 Analytics of adherence trends.
- 🌐 Multi-language support.

---

## 🚀 Getting Started

### Prerequisites
Make sure you have installed:
- **Java 21+** — [Download](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html)
- **Maven 3.6+** — [Download](https://maven.apache.org/download.cgi)
- **PostgreSQL 15+** — [Download](https://www.postgresql.org/download/)
- **Docker (optional)** — [Download](https://www.docker.com/get-started)
- **Git** — [Download](https://git-scm.com/downloads)

### Quick Start
```bash
 # Clone the repository
git clone https://github.com/your-org/medication-reminder-backend.git
cd medication-reminder-backend

 # Build the project
./mvnw clean install

 # Run the application
./mvnw spring-boot:run
```
The API will be available at 👉 http://localhost:8080

## ⚙️ Installation

### 1. Clone the Repository
```bash
  git clone https://github.com/your-org/medication-reminder-backend.git
  cd medication-reminder-backend
```

### 2. Configure Database
```yaml
Create a MySQL database and edit `src/main/resources/application.yml`:
spring:
datasource:
url: jdbc:postgresql://localhost:5432/medication_db
username: your_username
password: your_password
jpa:
hibernate:
ddl-auto: update
show-sql: true
properties:
hibernate:
dialect: org.hibernate.dialect.PostgreSQLDialect
format_sql: true

jwt:
secret: your_jwt_secret_key
expiration: 86400000 # 24 hours

server:
port: 8080
```

## 🏃‍♂️ Running the Application
```bash
  ./mvnw spring-boot:run
```
### 🔧 Technologies
- **Java 21** - Core programming language
- **Spring Boot 3.5.4** - Application framework
- **Spring Security + JWT** - Provides authentication and authorization
- **Spring Data JPA + Hibernate** - Data persistence and ORM
- **MySQL 8.0+** - Relational database
- **GitHub Actions (CI/CD)** - Continuous integration and deployment
- **JUnit 5 + Mockito** - Unit and integration testing

---


### 🧪 Tests
- **Unit Tests** - Test business logic in services
- **Integration Tests** - Test controller endpoints
- **Coverage** - Minimum 70% test coverage
- **Run Tests**
- ``` bash
    - ./mvnw test
    - ./mvnw test jacoco:report
  ```
- **Coverage Report** - `target/site/jacoco/index.html`

---
### 🔄 Automation
- **GitHub Actions** - Automates CI/CD pipelines
- **Automated test execution** - Runs unit and integration tests
- **Conventional commit validation** - Ensures commit message standards

---

### 🤝 Contributing
- **feat:** Add new features
- **fix:** Bug fixes
- **docs:** Documentation updates
- **style:** Code style changes
- **refactor:** Code refactoring
- **test:** Add or update tests
- **chore:** Maintenance tasks

## 👥 Team Members
<table>
  <tr>
    <td align="center">
      <a href="https://github.com/debsrdev">
        <img src="https://github.com/debsrdev.png" width="100px;" alt="debsrdev"/><br />
        <sub><b>debsrdev</b></sub>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/Ivanlr7">
        <img src="https://github.com/Ivanlr7.png" width="100px;" alt="Ivanlr7"/><br />
        <sub><b>Ivanlr7</b></sub>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/EstherTapias">
        <img src="https://github.com/EstherTapias.png" width="100px;" alt="EstherTapias"/><br />
        <sub><b>EstherTapias</b></sub>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/PaolaAPL17">
        <img src="https://github.com/PaolaAPL17.png" width="100px;" alt="PaolaAPL17"/><br />
        <sub><b>PaolaAPL17</b></sub>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/Bertopf">
        <img src="https://github.com/Bertopf.png" width="100px;" alt="Bertopf"/><br />
        <sub><b>Bertopf</b></sub>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/gabriela-her">
        <img src="https://github.com/gabriela-her.png" width="100px;" alt="gabriela-her"/><br />
        <sub><b>gabriela-her</b></sub>
      </a>
    </td>
  </tr>
</table>
