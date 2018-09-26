package com.benchwarmers.grads.grizzlystoregoogleuser.entities;

import com.benchwarmers.grads.grizzlystoregoogleuser.entities.Profile;
import com.benchwarmers.grads.grizzlystoregoogleuser.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Date;

@Entity
@Table(name="GoogleAccount")
public class GoogleAccount extends Data {
    @Id
    @Column(name = "id_Account", nullable = false)
    private String idGoogleAccount;

    @Column(name = "account_EmailAddress", nullable = false, unique = true)
    @Email
    private String googleAccountEmailAddress;

    @CreationTimestamp
    @Column(name = "DateTime", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModified;

    @OneToOne(mappedBy = "googleAccount")
    private Profile profile;

    public String getIdGoogleAccount() {
        return idGoogleAccount;
    }

    public void setIdGoogleAccount(String idGoogleAccount) {
        this.idGoogleAccount = idGoogleAccount;
    }

    public String getGoogleAccountEmailAddress() {
        return googleAccountEmailAddress;
    }

    public void setGoogleAccountEmailAddress(String googleAccountEmailAddress) {
        this.googleAccountEmailAddress = googleAccountEmailAddress.toLowerCase();
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }
}
