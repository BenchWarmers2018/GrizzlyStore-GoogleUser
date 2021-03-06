package com.benchwarmers.grads.grizzlystoregoogleuser;

import com.benchwarmers.grads.grizzlystoregoogleuser.entities.GoogleAccount;
import com.benchwarmers.grads.grizzlystoregoogleuser.repositories.GoogleAccount_Repository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;

public class GrizzlystoreUserGoogleAccountTests {
    @Mock
    private GoogleAccount_Repository mockedGoogleAccountRepository;

    @Mock
    private GoogleAccount testGoogleAccount;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        testGoogleAccount = new GoogleAccount();
//        testGoogleAccount.setIdGoogleAccount(UUID.randomUUID());
        testGoogleAccount.setAccountEmailAddress("ANTO@gmail.com");
        testGoogleAccount.setLastModified(Date.from(Instant.now()));
        Mockito.when(mockedGoogleAccountRepository.save( Mockito.any(GoogleAccount.class) )).thenReturn(testGoogleAccount);
    }

    @Test
    public void saveGoogleAccount() {
        GoogleAccount testAccount2 = mockedGoogleAccountRepository.save(new GoogleAccount());
        Assert.assertNotNull(testAccount2);
    }

    @Test
    public void googleAccountHasCorrectEmailAddress() {
        GoogleAccount newAccount = mockedGoogleAccountRepository.save(new GoogleAccount());
        Assert.assertEquals("ANTO@gmail.com", newAccount.getAccountEmailAddress());
    }

    @Test
    public void accountHasIncorrectEmailAddress() {
        GoogleAccount newAccount = mockedGoogleAccountRepository.save(new GoogleAccount());
        newAccount.setAccountEmailAddress("Anto@xyz.com");
        Assert.assertNotEquals("anto@abc.com", newAccount.getAccountEmailAddress());
    }

//    @Test
//    public void accountHasUUID() {
//        GoogleAccount newAccount = mockedGoogleAccountRepository.save(new GoogleAccount());
//        Assert.assertNotNull(newAccount.getIdGoogleAccount());
//    }

    @Test
    public void accountHasLastModifiedDatetime() {
        GoogleAccount newAccount = mockedGoogleAccountRepository.save(new GoogleAccount());
        Assert.assertNotNull(newAccount.getLastModified());
    }

    @Test
    public void createGoogleAccountJsonResponse() {
        JsonResponse response = new JsonResponse();
        response.addEntity(testGoogleAccount);
        response.setStatus(HttpStatus.OK);

        Assert.assertEquals(response.getStatus(), HttpStatus.OK);
        Assert.assertTrue(response.getEntities().contains(testGoogleAccount));
    }
}
