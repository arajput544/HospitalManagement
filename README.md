
# 🏥 Hospital Management Microservices Project

A full-stack **Hospital Management System** built using modern web technologies and microservices architecture. Designed to replicate enterprise-grade systems like those developed during my tenure at Synergy Medical Informatics.

---

## 📦 Tech Stack

### 💻 Frontend:
- React.js
- Axios
- Tailwind CSS

### ⚙️ Backend:
- Java 17
- Spring Boot (REST, JPA, Security)
- Spring Cloud (Eureka, Gateway, Config)

### 🧾 Database:
- MySQL (Per Service DB)
- PostgreSQL (For Auth)

### ☁️ Infrastructure:
- Docker
- Docker Compose
- Kubernetes (Minikube)
- AWS EC2 for deployment

### 🛡 Security:
- Spring Security
- JWT Token-based Authentication
- OAuth2 (for future expansion)

### 📊 Monitoring:  (Future)
- Prometheus
- Grafana

### 🚀 CI/CD:  (Future)
- GitHub Actions
- Jenkins (for enterprise-style optional automation)

---

## 🧩 Microservices Architecture

Each service is independent, follows single responsibility, and communicates via REST APIs.

### 🩺 1. Patient Service
- Add/Edit/View/Delete Patient Info
- Filter by ID, disease, age, gender
- MySQL backed, REST endpoints

### 👨‍⚕️ 2. Doctor Service  (Future)
- Manage doctors, specialization, shifts
- REST endpoints with Spring Boot
- Connects with Appointment & Patient services

### 📅 3. Appointment Service
- Book, update, cancel appointments
- Validates doctor availability
- Interacts with Doctor & Patient services

### 💊 4. Inventory Service
- Manage medical stock: add, track, alert low stock
- REST API to support frontend usage
- Integrated with monitoring dashboard (Prometheus)

### 🔐 5. Authentication Service
- Role-based login: Admin, Doctor, Receptionist
- JWT authentication using Spring Security
- PostgreSQL for user storage

### 🌐 6. API Gateway
- Unified entry for all backend APIs
- Route requests to appropriate microservices
- Load-balancing and simple rate limiting

### 🧭 7. Eureka Service Registry
- Service discovery mechanism
- Allows dynamic scaling of services

### ⚙️ 8. Config Server
- Centralized configuration management
- Pulls config values for each microservice

---

## 🎨 Frontend - React.js

- Built with React.js and Tailwind CSS
- Axios for API integration
- React Router for navigation
- JWT token handling
- Role-based UI rendering:
  - **Admin Dashboard**: Manage users, reports
  - **Doctor Portal**: View appointments, patient info
  - **Reception Panel**: Book appointments, manage patients

---

## 📊 Monitoring & Observability  (Future)

- **Prometheus**: Collects metrics from microservices
- **Grafana**: Visualizes real-time metrics and alerts
- Dashboards for:
  - Service health
  - API call latency
  - Inventory stock alerts
  - Appointment volume

---

## 🚀 CI/CD Pipeline (Future)

- **GitHub Actions**: Triggers on push, runs tests, builds Docker images
- **Docker Compose**: Local service orchestration
- **Jenkins** (optional): Can be used for more complex enterprise pipelines
- **Docker Hub**: Pushes images for Kubernetes use
- **Kubernetes**: Deploys all services with ConfigMaps and Secrets

---

## 🧭 System Architecture Diagram


```text
    [ React Frontend ]
         |
 -----------------------
 |                     |
/patient-login     /doctor-login
      |                 |
      ↓                 ↓
[ API Gateway (Spring Cloud Gateway) - Port 8081 ]
        |
  -------------------------------
  |      |      |      |        |
  ↓      ↓      ↓      ↓        ↓
[AuthService] [PatientService] [DoctorService] [AppointmentService]
    Port:9095     Port:9090       Port:9092        Port:9091

[MySQL DB - Auth] [MySQL DB - Patients] [MySQL DB - Doctors] [MySQL DB - Appointments]
```
