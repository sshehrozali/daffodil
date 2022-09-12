package com.eDukan.customer;

public record CustomerService() {
    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder().firstname(request.firstname()).lastname(request.lastname()).email(request.email()).build();
    }
}
