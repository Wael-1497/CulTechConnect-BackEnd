package tn.sae.authenticationservice.repository;

import tn.sae.authenticationservice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    boolean existsByEmail(String email);

    Optional<Customer> findByEmail(String email);
}
