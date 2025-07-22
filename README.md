# SportsApp 🏅

**SportsApp** is a full-stack Java Spring Boot web application that allows users to explore various sports and their disciplines, including Athletics and Swimming. Users can register, browse champions and world records, and interact through comments.

---

## ✨ Features

- 🔐 User registration and login  
- 🏃 Browse sports and related disciplines (Athletics and Swimming)  
- 🥇 View champions and world records per discipline  
- 💬 Add and view user comments  
- 🛡️ Admin panel for managing users and changing roles  
# SportsApp 🏅

![Java](https://img.shields.io/badge/Java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-%236DB33F.svg?style=for-the-badge&logo=springboot&logoColor=white)
![Spring Security](https://img.shields.io/badge/Security-%236DB33F.svg?style=for-the-badge&logo=springsecurity&logoColor=white)
![Hibernate](https://img.shields.io/badge/Hibernate-%234895C2.svg?style=for-the-badge&logo=hibernate&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-%2300f.svg?style=for-the-badge&logo=mysql&logoColor=white)
![Thymeleaf](https://img.shields.io/badge/Thymeleaf-005F0F?style=for-the-badge&logo=thymeleaf&logoColor=white)
![Cloudinary](https://img.shields.io/badge/Cloudinary-3448C5?style=for-the-badge&logo=cloudinary&logoColor=white)
![Flyway](https://img.shields.io/badge/Flyway-CC0000?style=for-the-badge&logo=flyway&logoColor=white)
![HTML5](https://img.shields.io/badge/HTML5-%23E34F26.svg?style=for-the-badge&logo=html5&logoColor=white)
![CSS3](https://img.shields.io/badge/CSS3-%231572B6.svg?style=for-the-badge&logo=css3&logoColor=white)
![Git](https://img.shields.io/badge/Git-%23F05032.svg?style=for-the-badge&logo=git&logoColor=white)
![GitHub](https://img.shields.io/badge/GitHub-%23121011.svg?style=for-the-badge&logo=github&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-%23C71A36.svg?style=for-the-badge&logo=apachemaven&logoColor=white)
![REST API](https://img.shields.io/badge/REST_API-%23007ACC.svg?style=for-the-badge&logo=fastapi&logoColor=white)

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
---

## 🌐 Monitoring with UptimeRobot

To ensure the Render deployment stays responsive, this project uses [UptimeRobot](https://uptimerobot.com/) for periodic health checks.

### ✅ Why?
Render puts free services to sleep after periods of inactivity, which can result in slow initial load times. UptimeRobot sends a ping every 5 minutes to keep the app "awake" and responsive.

### 🔧 How it's configured:
- **Service**: UptimeRobot (Free Plan)  
- **Type**: HTTP(s)  
- **URL**: `https://sportsapp-web.onrender.com/`  
- **Interval**: Every 5 minutes  
- **Setup time**: ~5 minutes  
- **No code changes required** 🎉

You can optionally monitor additional endpoints such as `/home`, `/athletics`, or `/swimming`.

