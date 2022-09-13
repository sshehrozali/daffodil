## Microservices
* **Customer:** The goal of this microservice is to handle all Customer registration requests.
* **Fraud:** The goal of this microservice is to handle and perform all fraud checks i.e. if a customer is fraudulent or not.

### Ports
* **8080:** Customer microservice
* **8081:** Fraud microservice

### Dependencies
* Spring Framework
* Spring Boot
* Spring Boot Web
* Spring Boot Test
* Spring Data JPA
* Spring Cloud Sleuth
* H2 Database (for in-memory testing)
* Project lombok

### Distributed Tracing
* **Trade ID:** The ID which will remain consistent throughout each request handled.
* **Span ID:** The ID which will be changed as soon as it transitions from one service to another.
* 
### Eureka Server connection pool
![](misc/eureka-server.png)