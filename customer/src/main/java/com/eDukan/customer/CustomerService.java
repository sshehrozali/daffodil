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
        customerRepository.saveAndFlush(customer);

        // Check if email is valid
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        if (pattern.matcher(customer.getEmail()).matches()) {
            // Means Email is valid
            log.info("Customer Email " + customer.getEmail() + " is valid");
        } else {
            throw new IllegalStateException("Customer Email is not Valid");
        }

        // todo: check if email is already taken
        // Check if customer is fraudulent
        FraudCheckHistoryResponse fraudCheckHistoryResponse = restTemplate
                .getForObject("http://FRAUD/api/v1/fraud-check/{customerId}",
                FraudCheckHistoryResponse.class,
                        customer.getId());
        if (fraudCheckHistoryResponse.isFraudster()) {
            // If Customer is Fraudster -> Throw exception
            throw new IllegalStateException("Customer is Fraudster");
        } else {
            // send notification
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
}
