# 🍔 SmartFood Delivery Application

A **Java Spring Boot Microservices-based Food Delivery Application** designed to manage users, restaurants, orders, payments, and notifications.

 Project Overview

SmartFood is a backend application developed using **Spring Boot and Microservices Architecture**. It provides REST APIs for food delivery operations and uses Spring Cloud components for service discovery, routing, and communication.

Features

* User Registration and Login
* JWT Authentication
* Role-Based Authorization
* Restaurant Management
* Food and Menu Management
* Order Management
* Payment Management
* Notification Service
* REST API Communication
* Service Discovery
* API Gateway

##  Architecture

```text
                    Client
                      |
                      v
                API Gateway
                      |
                      v
                Eureka Server
                      |
       +--------------+--------------+
       |              |              |
       v              v              v
   User Service   Restaurant      Order Service
                    Service           |
                                      v
                              Payment Service
                                      |
                                      v
                            Notification Service
```

## 🧩 Microservices

| Service              | Responsibility                              |
| -------------------- | ------------------------------------------- |
| User Service         | User registration, login and authentication |
| Restaurant Service   | Restaurant management                       |
| Order Service        | Order creation and management               |
| Payment Service      | Payment processing                          |
| Notification Service | User notifications                          |
| API Gateway          | Routes client requests                      |
| Eureka Server        | Service discovery                           |
| Admin Server         | Application monitoring                      |

## 🛠️ Technologies

### Backend

* Java
* Spring Boot
* Spring MVC
* Spring Data JPA
* Hibernate
* REST APIs

### Microservices

* Spring Cloud
* Eureka Server
* Spring Cloud Gateway
* OpenFeign

### Security

* Spring Security
* JWT
* Role-Based Authorization

### Database

* MySQL

### Tools

* Maven
* Eclipse / IntelliJ IDEA
* Postman
* Git
* GitHub

## 📁 Project Structure

```text
SmartFood-Delivery-Application/
│
├── SmartFood-AdminServer/
├── SmartFood-ApiGateway/
├── SmartFood-EurekaServer/
├── SmartFood-NotificationService/
├── SmartFood-OrderService/
├── SmartFood-PaymentService/
├── SmartFood-RestaurantService/
├── SmartFood-UserService/
├── SmartFoodDeliveryApp/
│
├── README.md
└── .gitignore
```





