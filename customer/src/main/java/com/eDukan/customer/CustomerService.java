package com.eDukan.customer;

public record CustomerService(CustomerRepository customerRepository) {
    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder().firstname(request.firstname()).lastname(request.lastname()).email(request.email()).build();
        customerRepository.save(customer);
    }
}
