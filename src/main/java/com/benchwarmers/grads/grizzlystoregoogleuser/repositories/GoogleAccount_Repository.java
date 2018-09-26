package com.benchwarmers.grads.grizzlystoregoogleuser.repositories;

import com.benchwarmers.grads.grizzlystoregoogleuser.entities.GoogleAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface GoogleAccount_Repository extends JpaRepository<GoogleAccount, String> {
    GoogleAccount findByGoogleAccountEmailAddress(String emailAddress);
    boolean existsByGoogleAccountEmailAddress(String emailAddress);
    GoogleAccount findByIdGoogleAccount(String idGoogleAccount);
    boolean existsByIdGoogleAccount(String idGoogleAccount);
}
