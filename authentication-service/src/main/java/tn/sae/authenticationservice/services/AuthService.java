package tn.sae.authenticationservice.services;

import tn.sae.authenticationservice.dto.SignupRequest;
import tn.sae.authenticationservice.entities.Customer;

public interface AuthService {
    Customer createCustomer(SignupRequest signupRequest);
}
