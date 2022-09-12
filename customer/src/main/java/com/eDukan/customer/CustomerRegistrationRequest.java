package com.eDukan.customer;

public record CustomerRegistrationRequest(
        String firstname,
        String lastname,
        String email
) {
}
