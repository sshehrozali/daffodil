package com.eDukan.customer;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;
    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder().firstname(request.firstname()).lastname(request.lastname()).email(request.email()).build();
        // todo: check if email is valid
        // todo: check if email is already taken
        // todo: check if customer is fraudulent
        // todo: send notification

        customerRepository.save(customer);
    }
}
