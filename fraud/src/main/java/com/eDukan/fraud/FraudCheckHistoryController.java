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
public class FraudCheckHistoryController {
    private final FraudCheckHistoryService fraudCheckHistoryService;

    @GetMapping(path = "{customerId}")
    public FraudCheckHistoryResponse isFraudulent(@PathVariable("customerId") Integer customerId) {
        boolean isFraudulent = fraudCheckHistoryService.isFraudulentCustomer(customerId);
        log.info("Fraud Check Request for Customer: {}", customerId);
        return new FraudCheckHistoryResponse(isFraudulent);
    }
}
