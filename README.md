# 📝 To-Do Management REST API

A Spring Boot based RESTful backend application that allows users to manage daily tasks with full CRUD functionality.
This project demonstrates backend development fundamentals including layered architecture, REST API design, and MySQL database integration for persistent storage.

---

## 🚀 Features

* Create a new task
* Retrieve all tasks
* Retrieve task by ID
* Update existing task
* Delete task
* Persistent storage using MySQL
* RESTful API design

---

## 🛠️ Tech Stack

* Java
* Spring Boot
* Spring Data JPA (Hibernate)
* MySQL
* Maven
* Postman (API testing)

---

## 📂 Project Architecture

The application follows a layered architecture:

* **Controller** → Handles HTTP requests and responses
* **Service** → Contains business logic
* **Repository** → Handles database interactions
* **Entity** → Maps Java objects to database tables

---

## 📡 API Endpoints

### Get all tasks

GET /tasks

### Get task by ID

GET /tasks/{id}

### Create task

POST /tasks

### Update task

PUT /tasks/{id}

### Delete task

DELETE /tasks/{id}

---

## ⚙️ How to Run the Project

### 1️⃣ Clone the repository

```bash
git clone https://github.com/Ek-36/to_do_task_app.git
```

### 2️⃣ Navigate to the project folder

```bash
cd to_do_task_app
```

### 3️⃣ Configure MySQL

Create a database in MySQL:

```sql
CREATE DATABASE todo_db;
```

Update `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/todo_db
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD
```

### 4️⃣ Run the application

```bash
mvn spring-boot:run
```

### 5️⃣ Test APIs

Use Postman or browser to test endpoints.

---

## 🎯 Learning Outcomes

* Building RESTful APIs using Spring Boot
* Implementing CRUD operations with layered architecture
* Integrating MySQL using JPA/Hibernate
* Managing database entities and persistence
* Testing APIs using Postman

---

## 🔮 Future Improvements

* Implement DTO pattern for request/response handling
* Add validation using `@Valid` annotations
* Implement global exception handling
* Add pagination and sorting
* Implement authentication using Spring Security

---

## 👨‍💻 Author

**Edwin Mark K**
B.Tech AI & Data Science — REVA University

GitHub: https://github.com/Ek-36
LinkedIn: https://linkedin.com/in/edwin-mark-k-678b28293
