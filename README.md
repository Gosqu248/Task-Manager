# Task Manager

[![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)](https://spring.io/projects/spring-boot)
[![PostgreSQL](https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white)](https://www.postgresql.org/)
[![Redis](https://img.shields.io/badge/Redis-DC382D?style=for-the-badge&logo=redis&logoColor=white)](https://redis.io/)
[![Java](https://img.shields.io/badge/Java_21-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://www.oracle.com/java/)
[![Docker](https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white)](https://www.docker.com/)

A simple task management application built with Spring Boot that provides REST API endpoints for managing tasks.

## 🔗 Related Projects

- **Frontend Repository**: [Task Manager Frontend](https://github.com/Gosqu248/Task-Manager-Frontend)

## 📋 Overview

This project is a learning exercise focused on building a task management system with modern technologies. It allows users to create, read, update, and delete tasks through a RESTful API.

## 🛠️ Technologies Used

- **Spring Boot**: Framework for building the application
- **PostgreSQL**: Database for persistent storage of tasks
- **Redis**: Used for caching to improve performance
- **Docker**: Containerization for easy deployment
- **Maven**: Dependency management and build tool
- **Java 21**: Programming language

## 🚀 Setup Instructions

### Prerequisites

- Java 21
- Docker and Docker Compose

### Running the Application

1. Clone the repository
2. Start the required services using Docker Compose:
   ```bash
   docker-compose up -d
   ```
3. Build and run the application:
   ```bash
   ./mvnw spring-boot:run
   ```

## 🔌 API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| `GET` | `/api/task` | Get all tasks |
| `GET` | `/api/task/{task-id}` | Get a specific task |
| `POST` | `/api/task` | Create a new task |
| `PUT` | `/api/task/{task-id}` | Update a task |
| `PUT` | `/api/task/complete/{task-id}` | Mark a task as complete |
| `DELETE` | `/api/task/{task-id}` | Delete a task |

## 💾 Database Configuration

The application is configured to connect to a PostgreSQL database. The connection details can be found in the `application.properties` file.

## 🚀 Redis Integration

This project uses Redis for caching to improve performance. Redis configuration is defined in the `application.properties` file and the service is included in the Docker Compose setup.