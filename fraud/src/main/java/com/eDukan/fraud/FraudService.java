package com.eDukan.fraud;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class FraudService {
    private final FraudRepository fraudRepository;

    public Boolean isFraudulentCustomer(String customerEmail) {
        // todo: check if Customer record already exists

        fraudRepository.save(
                Fraud.builder()
                        .customerEmail(customerEmail)
                        .isFraudster(false)
                        .createdAt(LocalDateTime.now())
                        .build()
        );
        return false;
    }
}
