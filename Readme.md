# Welcome to Rozhano!

<div align="center">
  <img height="100" width="100" src="assets/rozhano-logo.png" alt="Rozhano Logo">
  <br>
  <strong>Rozhano</strong>
</div>
<br>

![License](https://img.shields.io/badge/License-MIT-brightgreen)
![Contributions Welcome](https://img.shields.io/badge/contributions-welcome-brightgreen.svg?style=flat)
![API](https://img.shields.io/badge/API-24%2B-brightgreen.svg?style=flat)
![GitHub](https://img.shields.io/badge/GitHub-AmirGolmoradi-%60Z%60?logo=github&color=blue)

---

## Table of Contents

1. [Project Overview](#project-overview)
2. [Built With](#built-with)
    - [Backend](#backend)
    - [Web](#web)
3. [Contributing](#contributing)
4. [Code of Conduct](#code-of-conduct)
5. [License](#license)

---

## Project Overview

**Rozhano** is a state-of-the-art multi-service e-commerce platform designed to efficiently manage inventory, orders,
payments, customers, and products. Leveraging a microservices architecture, Rozhano utilizes AI-driven algorithms to
deliver personalized user experiences and optimize operational workflows. The platform ensures real-time data
synchronization, robust security features including OAuth2 and JWT authentication, and supports multiple database
systems for enhanced flexibility.

---

## Built With

### Backend

The backend of Rozhano is developed using the following technologies:

| Technology               | Description                                                                                                              |
|--------------------------|--------------------------------------------------------------------------------------------------------------------------|
| **Java Spring Boot**     | A powerful framework for building RESTful APIs and scalable microservices.                                               |
| **PostgreSQL**           | A relational database for managing structured data with advanced querying capabilities.                                  |
| **MongoDB**              | A NoSQL database designed for handling unstructured data and high-velocity data needs.                                   |
| **Redis**                | An in-memory data structure store used for caching and session management to enhance performance.                        |
| **Docker**               | Employed for containerizing microservices, ensuring consistent environments across development, testing, and production. |
| **JWT & OAuth2**         | Implemented for securing APIs and user authentication through JSON Web Tokens (JWT) and OAuth2 protocols.                |
| **Spring Cloud**         | For building cloud-native applications and managing microservices efficiently.                                           |
| **RabbitMQ**             | A message broker that facilitates communication between microservices, enhancing scalability and fault tolerance.        |
| **JUnit & Mockito**      | Used for writing unit tests to ensure high code quality and stability.                                                   |
| **Domain Driven Design** | A design approach that aligns code and domain concepts based on core business logic.                                     |

### Web

The web component of Rozhano is developed using the following technologies:

| Technology       | Description                                                                                                                   |
|------------------|-------------------------------------------------------------------------------------------------------------------------------|
| **React**        | A JavaScript library for building user interfaces, allowing for the development of interactive and dynamic web applications.  |
| **Redux**        | A state management library that helps manage application state in a predictable way, ensuring a seamless user experience.     |
| **TypeScript**   | A superset of JavaScript that adds static typing, enhancing code quality and maintainability.                                 |
| **Tailwind CSS** | A utility-first CSS framework                                                                                                 |
| **Axios**        | A promise-based HTTP client for making API requests, enabling smooth communication between the frontend and backend services. |
| **Webpack**      | A module bundler that compiles JavaScript modules and assets, optimizing the application for production.                      |

---

## Contributing

We welcome contributions from the open-source community! Please follow the steps below if you wish to contribute:

### Code Quality and Style

- Follow consistent code formatting rules.
- Write clear, descriptive commit messages.
- Use proper naming conventions for variables, methods, and classes.

**Bad Example**:
```java
  public void a() { /* Code here */ }
```

**Good Example**:
```java
  public void ProcessOrder() { /* Code here */ }
```

### Issue Reporting and Resolution

- Always open an issue for bugs or new feature requests before starting any work.
- Provide a detailed description of the issue or feature request, including steps to reproduce if it's a bug.

**Bad Example**:
"App crashes when I open the orders page."

**Good Example**:
"App crashes on the Orders page after clicking on a specific order ID. Steps to reproduce:
1. Open the app.
2. Navigate to the Orders tab.
3. Click on the order ID '12345'."

### Pull Requests

- Ensure your branch is up to date with the latest `main` branch.
- Make sure your code passes all the tests before creating a pull request.
- Include a description of what your pull request does and why.
