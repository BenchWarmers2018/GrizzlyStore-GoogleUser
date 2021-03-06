package com.benchwarmers.grads.grizzlystoregoogleuser.repositories;

import com.benchwarmers.grads.grizzlystoregoogleuser.entities.GoogleAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface GoogleAccount_Repository extends JpaRepository<GoogleAccount, UUID> {

    GoogleAccount findByAccountEmailAddress(String emailAddress);
    boolean existsByAccountEmailAddress(String emailAddress);
    GoogleAccount findByIdAccount(String idAccount);
    boolean existsByIdAccount(String idAccount);
}
