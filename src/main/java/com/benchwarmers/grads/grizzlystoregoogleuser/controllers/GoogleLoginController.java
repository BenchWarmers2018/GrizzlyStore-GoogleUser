package com.benchwarmers.grads.grizzlystoregoogleuser.controllers;

import com.benchwarmers.grads.grizzlystoregoogleuser.JsonResponse;
import com.benchwarmers.grads.grizzlystoregoogleuser.entities.GoogleAccount;
import com.benchwarmers.grads.grizzlystoregoogleuser.entities.GoogleProfile;
import com.benchwarmers.grads.grizzlystoregoogleuser.repositories.GoogleAccount_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;

@RestController
@CrossOrigin
@RequestMapping(path = "/googlelogin")
public class GoogleLoginController {
    @Autowired
    private GoogleAccount_Repository googleAccountRepository;

    @PostMapping(path ="/googleauthenticate", consumes ="application/json", produces ="application/json")
    public ResponseEntity login (@RequestBody GoogleAccount googleAccount) {
        //Checks if google account already exists in database by email
        JsonResponse response = new JsonResponse();
        if(!googleAccountRepository.existsByGoogleAccountEmailAddress(googleAccount.getGoogleAccountEmailAddress())){

            //If account doesn't exist, make new google account
            GoogleAccount newGoogleAccount = new GoogleAccount();
            GoogleProfile googleProfile = new GoogleProfile();
            //Popularise
            newGoogleAccount.setGoogleAccountEmailAddress(googleAccount.getGoogleAccountEmailAddress());
            newGoogleAccount.setProfile(googleProfile);
            googleAccountRepository.save(newGoogleAccount);
            response.setStatus(HttpStatus.OK);
            response.addEntity(newGoogleAccount);
            System.out.println("ACCOUNT DOES NOT EXIST AND IS BEING CREATED");
            return response.createResponse();
        }
        else {
            GoogleAccount existingAccount = getExistingAccount(googleAccount.getGoogleAccountEmailAddress());
            response.setStatus(HttpStatus.OK);
            response.addEntity(existingAccount);
            System.out.println("EXISTING ACCOUNT HAS BEEN RETURNED");
            return response.createResponse();
        }
    }


    private GoogleAccount getExistingAccount(String email) {
        return googleAccountRepository.findByGoogleAccountEmailAddress(email);
    }


}
