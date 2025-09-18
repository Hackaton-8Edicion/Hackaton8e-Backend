# 💊 Medication Reminder - RESTful API

A RESTful API designed to manage medications, schedules, and daily intake tracking.  
This backend provides a secure and scalable system that helps users keep track of their prescriptions and receive reminders.

![Java](https://img.shields.io/badge/Java-21-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.4-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![Spring Security](https://img.shields.io/badge/Spring%20Security-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![Swagger](https://img.shields.io/badge/Swagger-85EA2D?style=for-the-badge&logo=swagger&logoColor=black)
![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)

---

## 📋 Table of Contents
- [🎯 Project Overview](#-project-overview)
- [✨ Features](#-features-implemented)
- [🚀 Getting Started](#-getting-started)
- [⚙️ Installation](#-installation)
- [🏃 Running the Application](#-running-the-application)
- [🌐 API Endpoints](#endpoints-implemented)
- [📖 API Documentation (Swagger)](#api-documentation-with-swagger)
- [🔧 Technologies](#-technologies)
- [🧪 Tests](#-tests)
- [👥 Team Members](#-team-members)

---

## 🎯 Project Overview
Managing medication routines is a daily challenge. Users often rely on fragmented reminders or manual tracking, which can result in missed doses.

**Medication Reminder API** addresses this problem by providing:
- Secure authentication and user accounts.
- A system to register medications and schedules.
- Endpoints to log daily intakes.
- Dashboard data to check compliance and upcoming doses.

---

## ✨ Features implemented
- 👤 User registration & login.
- 👤 User can consult their profile and update it. 
- 💊 CRUD operations for medications.
- ⏰ CRUD operations for treatments.

**Future Enhancements**
- ⏰ Schedule management (daily/weekly routines).
- ✅ Track whether medication was taken or missed.
- 📊 Dashboard endpoint to view today’s doses.
- 🔒 Role-based access (future enhancement: Admin/User separation).
- 🔔 Push notifications & reminders.
- 📈 History of treatments.

---

## 🚀 Getting Started

### Stack used

- **Java 21+**
- **Maven 3.6+**
- **MySQL**
- **Git**

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
Create a MySQL database called "group8" and create an .env file with the following data:
```yaml
  DB_URL=jdbc:mysql://localhost:3306/group8
  DB_USERNAME=your_username
  DB_PASSWORD=your_password
  SERVER_PORT=8080
```

## 🏃‍♂️ Running the Application
```bash
  ./mvnw spring-boot:run
```
### 🔧 Technologies
- **Java 21** - Core programming language
- **Spring Boot 3.5.4** - Application framework
- **Spring Security** - Provides authentication
- **Spring Data JPA + Hibernate** - Data persistence and ORM
- **MySQL 8.0+** - Relational database
- **JUnit 5 + Mockito** - Unit and integration testing

---

## API Documentation with Swagger

We integrated **Swagger (Springdoc OpenAPI)** to automatically generate interactive documentation for our REST API.  
This allows developers and testers to explore endpoints, send requests directly from the browser, and authenticate with **JWT tokens**.

👉 Swagger UI is available at:
```bash
  http://localhost:8080/swagger-ui.html
```

## Endpoints Implemented

### 🔑 Authentication
- **POST** `/api/auth/register` → Register a new user
- **POST** `/api/auth/login` → Login

### 👤 Users
- **GET** `/api/users/{id}` → Get user by ID
- **PUT** `/api/users/{id}` → Update user data

### 💊 Medications
- **GET** `/api/users/{userId}/medications` → Get all medications for a user
- **GET** `/api/users/{userId}/medications/{medicationId}` → Get one medication by ID
- **POST** `/api/users/{userId}/medications` → Create a new medication
- **PUT** `/api/users/{userId}/medications/{medicationId}` → Update an existing medication
- **DELETE** `/api/users/{userId}/medications/{medicationId}` → Delete a medication

### 🩺 Treatments
- **GET** `/api/users/{userId}/treatments` → Get all treatments for a user
- **GET** `/api/users/{userId}/treatments/{treatmentId}` → Get one treatment by ID
- **POST** `/api/users/{userId}/treatments` → Create a new treatment
- **PUT** `/api/users/{userId}/treatments/{treatmentId}` → Update an existing treatment
- **DELETE** `/api/users/{userId}/treatments/{treatmentId}` → Delete a treatment

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
