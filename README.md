# 📊 Expense Tracker Application

A full-stack **Expense Tracker** application built with **Spring Boot**, **JWT Authentication**, **Google OAuth**, **MySQL**, and **React.js**.
Users can securely log in, add expenses, view them, and manage their financial records.

---

## 🚀 Features

### 🔐 Authentication

* Email & Password login
* Google OAuth 2.0 login
* JWT-based stateless authentication
* Secure logout
* Protected routes

### 💸 Expense Management

* Add expense
* View expenses (user-specific)
* Persistent login on refresh
* Secure backend authorization

### 🧱 Architecture

* Spring Boot MVC (Controller → Service → Repository)
* RESTful APIs
* MySQL database
* React frontend (Vite)

---

## 🛠️ Tech Stack

### Backend

* Java 17
* Spring Boot
* Spring Security
* JWT
* Google OAuth2
* JPA / Hibernate
* MySQL

### Frontend

* React.js
* Vite
* React Router
* Fetch API

---

## 📁 Project Structure

```
expense-tracker/
│
├── backend/
│   ├── controller/
│   ├── service/
│   ├── repository/
│   ├── model/
│   ├── security/
│   └── resources/
│
├── expense-tracker-frontend/
│   ├── src/
│   │   ├── components/
│   │   ├── auth/
│   │   └── api/
│   └── main.jsx
│
└── README.md
```

---

## ⚙️ Backend Setup (Spring Boot)

### 1️⃣ Configure MySQL

Create database:

```sql
CREATE DATABASE expense_tracker;
```

### 2️⃣ `application.yaml` (SAFE VERSION)

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/expense_tracker
    username: root
    password: your_password

  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true

  security:
    oauth2:
      client:
        registration:
          google:
            client-id: ${GOOGLE_CLIENT_ID}
            client-secret: ${GOOGLE_CLIENT_SECRET}

jwt:
  expiration: 86400000
```

---

### 3️⃣ Environment Variables

Create `.env` (DO NOT COMMIT):

```env
GOOGLE_CLIENT_ID=your_google_client_id
GOOGLE_CLIENT_SECRET=your_google_client_secret
```

---

### 4️⃣ Run Backend

```bash
cd backend
./mvnw spring-boot:run
```

Backend runs on:

```
http://localhost:8080
```

---

## 🎨 Frontend Setup (React)

### 1️⃣ Install dependencies

```bash
cd expense-tracker-frontend
npm install
```

### 2️⃣ Start frontend

```bash
npm run dev
```

Frontend runs on:

```
http://localhost:5173
```

---

## 🔑 API Endpoints

### Auth

| Method | Endpoint                       | Description     |
| ------ | ------------------------------ | --------------- |
| POST   | `/auth/register`               | Register user   |
| POST   | `/auth/login`                  | Login & get JWT |
| GET    | `/oauth2/authorization/google` | Google login    |

### Expenses

| Method | Endpoint    | Description       |
| ------ | ----------- | ----------------- |
| POST   | `/expenses` | Add expense       |
| GET    | `/expenses` | Get user expenses |

> All protected endpoints require:

```
Authorization: Bearer <JWT_TOKEN>
```

---

## 🧪 Testing with Postman

1. Login → get JWT token
2. Add header:

```
Authorization: Bearer <token>
```

3. Call `/expenses`

---

## 🔐 Security Notes

* JWT stored in `localStorage`
* No secrets committed to GitHub
* OAuth secrets handled via environment variables
* Stateless authentication (no sessions)

---

## 🧠 Learnings & Highlights

* Real-world JWT authentication
* Google OAuth integration
* Spring Security filters
* JPA entity relationships
* React protected routes
* Debugging production-level issues

---

## 📌 Future Enhancements

* Income management
* Expense deletion
* Monthly reports
* Charts & analytics
* Docker support
* Cloud deployment

---

## 👨‍💻 Author

**Sumit Kumar**
GitHub: [https://github.com/sumit18950](https://github.com/sumit18950)

---access the site here 
https://expensetracker1895.netlify.app/

## ⭐ If you like this project

Give it a ⭐ on GitHub!

---

If you want, I can also:

* Write **API documentation**
* Add **Dockerfile**
* Prepare **deployment guide**
* Improve **UI styling**

Just tell me 🚀
