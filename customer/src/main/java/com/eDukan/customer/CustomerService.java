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
        customerRepository.saveAndFlush(customer);

        // todo: check if email is valid
        // todo: check if email is already taken
        // check if customer is fraudulent
        FraudCheckHistoryResponse fraudCheckHistoryResponse = restTemplate.getForObject("http://FRAUD/api/v1/fraud-check/{customerId}",
                FraudCheckHistoryResponse.class, customer.getId());
        if (fraudCheckHistoryResponse.isFraudster()) {
            throw new IllegalStateException("Customer is Fraudster");
        }
        // todo: send notification
    }
}
