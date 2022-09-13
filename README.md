## Microservices
* **Customer:** The goal of this microservice is to handle all Customer registration requests.
* **Fraud:** The goal of this microservice is to handle and perform all fraud checks i.e. if a customer is fraudulent or not.

### Ports
* **8080:** Customer microservice
* **8081:** Fraud microservice

### Spring Dependencies
* Spring Framework
* Spring Boot
* Spring Boot Web
* Spring Boot Test
* Spring Data JPA
* H2 Database (for in-memory testing)
* Project lombok