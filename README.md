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
#### Spring Cloud Sleuth
* **Trade ID:** This ID will be same across the request.
* **Span ID:** This ID will be different in each unit of work in a given request.

#### Zipkin


### Eureka Server connection pool
![](misc/eureka-server.png)