# SportsApp 🏅

**SportsApp** is a full-stack Java Spring Boot web application that allows users to explore various sports and their disciplines, including Athletics and Swimming. Users can register, browse champions and world records, and interact through comments.

---

## ✨ Features

- 🔐 User registration and login  
- 🏃 Browse sports and related disciplines (Athletics and Swimming)  
- 🥇 View champions and world records per discipline  
- 💬 Add and view user comments  
- 🛡️ Admin panel for managing users and changing roles  

---

## 🛠️ Tech Stack

- Java 17  
- Spring Boot  
- Spring Security  
- Thymeleaf  
- MySQL  
- Cloudinary (image hosting)  
- HTML5, CSS3, Bootstrap  

---

## 🚀 Getting Started

### Prerequisites

- Java 17+  
- Maven  
- MySQL  
- IntelliJ IDEA  

### Installation Steps

```
Clone the repository:
git clone https://github.com/NicolaHristov/SportsApp.git

Open the project in IntelliJ:
- Open IntelliJ IDEA
- Choose File > Open and select the cloned project folder
- Import it as a Maven project (if prompted)

Create a MySQL database:
CREATE DATABASE sports_db;

Create a configuration file:
Add a file named application-secret.yml under src/main/resources with the following content:

spring:
  datasource:
    url: jdbc:mysql://localhost:3306/sports_db
    username: 
    password: 

cloudinary:
  cloud-name: 
  api-key: 
  api-secret: 

Run the application:
mvn spring-boot:run
```
