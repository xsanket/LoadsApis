# Liveasy Logistic Spring Boot Project


## Overview

This Spring Boot project is developed for Liveasy Logistic (TASK) to manage CRUD operations using Java 17 and PostgreSQL 15.

## Features

- CRUD APIs for managing logistics data.
- Developed using Spring Boot and Java 17.
- Utilizes PostgreSQL 15 as the database.

## Technologies Used

- Spring Boot
- Java 17
- PostgreSQL 15

## Postman APIs Testing (Screensot)
![API Testing Using Postman](https://github.com/xsanket/LoadsApis/assets/121148185/a3fc5b0c-7b40-4fce-85d8-7b57a2218f78)

## Setup

1. **Clone the Repository:**
   ```bash
   git clone https://github.com/xsanket/LoadsApis.git
   


## Configuratins

#PostgreSQL Database Configuration:
Host: localhost
Port: 5432
Username: your_username
Password: your_password
Database: liveeasy

# Spring Boot Application Configuration:
Application Properties: application.properties
 Database Configuration
spring.datasource.url=jdbc:postgresql://localhost:5432/liveasy
spring.datasource.username=*****
spring.datasource.password=*****

Hibernate Configuration
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update
debug=true

Server Configuration
server.port=8080





# Contribution
Contributions are welcome! Feel free to open issues or pull requests.
