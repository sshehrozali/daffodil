package com.eDukan.fraud;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/fraud-check")
@AllArgsConstructor
@Slf4j
public class FraudController {
    private final FraudService fraudService;

    @GetMapping(path = "{customerEmail}")
    public FraudResponse isFraudulent(@PathVariable("customerEmail") String customerEmail) {
        boolean isFraudulent = fraudService.isFraudulentCustomer(customerEmail);
        log.info("Fraud Check Request for Customer: {}", customerEmail);
        return new FraudResponse(isFraudulent);
    }
}
