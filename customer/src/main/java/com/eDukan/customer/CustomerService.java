package com.eDukan.customer;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.regex.Pattern;

@Service
@AllArgsConstructor
@Slf4j
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;

    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstname(request.firstname())
                .lastname(request.lastname())
                .email(request.email())
                .createdAt(LocalDateTime.now())
                .build();

        // Check if email is valid
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        if (pattern.matcher(customer.getEmail()).matches()) {
            // Means Email is valid
            log.info("Customer Email " + customer.getEmail() + " is valid");
        } else {
            throw new IllegalStateException("Customer Email is not Valid");
        }

        // Check if email is already taken
        if (customerRepository.findByEmail(customer.getEmail()) == null) {
            // Means Email is not already taken
            log.info("Customer Email is not already taken " + customer.getEmail());
        } else {
            throw new IllegalStateException("Customer Email is already taken " + customer.getEmail());
        }

        // Check if customer is fraudulent
        if (restTemplate.getForObject(
                "http://FRAUD/api/v1/fraud-check/{customerEmail}",
                FraudResponse.class,
                customer.getEmail()
        ).isFraudster()) {
            // Means Customer is Fraudster
            throw new IllegalStateException("Customer is Fraudster");
        } else {
            log.info("Customer {} is not Fraudster", customer.getEmail());
        }

        // then save Customer
        customerRepository.save(customer);

        // then send notification
        NotificationRequest notificationRequest = new NotificationRequest(
                customer.getEmail(),
                customer.getCreatedAt());
        NotificationResponse response = restTemplate
                .postForObject("http://NOTIFICATION/api/v1/notification",
                        notificationRequest,
                        NotificationResponse.class);
        log.info("Notification sent status: " + response.isSent());
    }
}
