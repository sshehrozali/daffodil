### High-level Overview
![](misc/distributed-system-design.png)
### Microservices
* **Customer:** The goal of this microservice is to handle all Customer registration requests.
* **Fraud:** The goal of this microservice is to handle and perform all fraud checks i.e. if a customer is fraudulent or not.

### Service Discovery
`eureka-server` uses `spring-cloud-starter-netflix-eureka-server` to register instance as server while other microservices `customer`, `fraud` uses `spring-cloud-starter-netflix-eureka-client` to register themselves as clients.

#### Load Balancing
The `customer` microservice uses round-robin DNS load balancing algorithm to perform routing to x instance of `fraud` microservice. `CustomerConfig` class contains `restTemplate()` method which is annotated with `@LoadBalanced` to perform load balancing.

#### Eureka Server connection pool
![](misc/eureka-server.png)


