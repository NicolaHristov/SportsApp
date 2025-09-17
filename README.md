# 👋 Hello, I'm Nikola Hristov

🎯 **Junior Java Developer**  
💡 Passionate about backend development, Spring Boot, and clean architecture  
🚀 Currently working on real-world portfolio projects  

## 🛠️ Technologies & Tools

![Java](https://img.shields.io/badge/Java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-%236DB33F.svg?style=for-the-badge&logo=springboot&logoColor=white)
![Hibernate](https://img.shields.io/badge/Hibernate-%234895C2.svg?style=for-the-badge&logo=hibernate&logoColor=white)
![Spring Security](https://img.shields.io/badge/Spring_Security-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-%2300f.svg?style=for-the-badge&logo=mysql&logoColor=white)
![Git](https://img.shields.io/badge/Git-%23F05032.svg?style=for-the-badge&logo=git&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-%23C71A36.svg?style=for-the-badge&logo=apachemaven&logoColor=white)
![REST API](https://img.shields.io/badge/REST_API-%23007ACC.svg?style=for-the-badge&logo=fastapi&logoColor=white)
![GitHub](https://img.shields.io/badge/GitHub-%23121011.svg?style=for-the-badge&logo=github&logoColor=white)
![Thymeleaf](https://img.shields.io/badge/Thymeleaf-005F0F?style=for-the-badge&logo=thymeleaf&logoColor=white)
![Cloudinary](https://img.shields.io/badge/Cloudinary-3448C5?style=for-the-badge&logo=cloudinary&logoColor=white)
![Flyway](https://img.shields.io/badge/Flyway-CC0000?style=for-the-badge&logo=flyway&logoColor=white)
![HTML5](https://img.shields.io/badge/HTML5-%23E34F26.svg?style=for-the-badge&logo=html5&logoColor=white)
![CSS3](https://img.shields.io/badge/CSS3-%231572B6.svg?style=for-the-badge&logo=css3&logoColor=white)


## 📂 Portfolio Projects

🔹 [🏃 Sports Statistics App (Live Demo)](https://sportsapp-web.onrender.com/)  
🔗 [GitHub Repository](https://github.com/nicolahristov/SportsApp)

A full-stack Spring Boot web application for managing athletics and swimming disciplines. Features include user registration and login, role-based access control, Cloudinary image integration, champion and world record pages, and a commenting system for logged-in users.

The app is deployed to Render and uses Railway (PostgreSQL) as the production database.  
Schema migrations are managed by Flyway to ensure consistency across environments and support version control of the database structure.

## 🖼️ Screenshots

### 🔐 Login Page
![Login Page](screenshots/login-page.png)

### 📝 Register Page
![Register Page](screenshots/register-page.png)

### 🏃 Athletics Page
![Athletics Page](screenshots/athletics-page.png)

### 🏊 Swimming Page
![Swimming Page](screenshots/swimming-page.png)

### 🏅 Swimming 50m Champion
![Swimming 50 Page](screenshots/swimming-50-page.png)

## 🔧 Getting Started

To run this project locally, follow these steps:

### ✅ Prerequisites

- Java 17 or higher  
- Maven  
- Git  
- PostgreSQL database (Railway for production deployment, local PostgreSQL optional) 

---

### 📦 Clone the Repository

```bash
git clone https://github.com/nicolahristov/SportsApp.git
cd SportsApp
``` 

### ⚙️ Configuration Setup

Create the following configuration files in the root directory (they are excluded via `.gitignore`):

#### `application-secret.yml`

```yaml
cloudinary:
  cloud-name: YOUR_CLOUD_NAME
  api-key: YOUR_API_KEY
  api-secret: YOUR_API_SECRET

admin:
  email: YOUR_ADMIN_EMAIL
  username: YOUR_ADMIN_USERNAME
  password: YOUR_SECURE_PASSWORD
``` 

#### `.env` *(optional)*

```properties
# You can use this to override secret values locally if needed
You can choose between two profiles depending on the environment:
```

### ☁️ Option 1: Run with Railway

This is the default and recommended setup to simulate a production environment:
```

```bash
mvn spring-boot:run -Dspring.profiles.active=railway
```
Make sure application-railway.yml contains your JDBC URL

### 🛠️ Option 2: Run Locally with MySQL

If you prefer to use a local MySQL server:

```bash
mvn spring-boot:run -Dspring.profiles.active=mysql
```
The local database will auto-create if it doesn't exist. Update credentials in application-mysql.yml if needed.

### 🌍 Access the App

Once the app is running, open:

[http://localhost:8080](http://localhost:8080)

You can register a new user or use your predefined admin credentials from application-secret.yml.

For testing admin features, use:
Username: admin
Password: admin123


## 🧠 Currently & Availability

- 🎯 **Currently learning:** Spring Security
- 👀 **Open to work:** Junior Java Developer roles (remote or on-site)  
- 📌 **Fun fact:** I enjoy building sports-related web apps — and since the beginning of this year, I’ve also been learning to play the traditional Bulgarian bagpipe (gaida)!


## 📈 GitHub Stats

![Nikola's GitHub stats](https://github-readme-stats.vercel.app/api?username=nicolahristov&show_icons=true&theme=default)

## 🌐 Find me around the web

- 💼 [LinkedIn](https://www.linkedin.com/in/nikola-hristov-54800236a/)
- 🌍 [Portfolio Website](https://sportsapp-web.onrender.com)
- ✉️ Email: swimmingman23@abv.bg

