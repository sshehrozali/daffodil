package com.eDukan.customer;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder().firstname(request.firstname()).lastname(request.lastname()).email(request.email()).build();
        customerRepository.save(customer);
    }
}
