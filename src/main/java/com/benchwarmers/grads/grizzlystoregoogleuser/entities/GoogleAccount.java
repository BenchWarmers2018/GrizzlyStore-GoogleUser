package com.benchwarmers.grads.grizzlystoregoogleuser.entities;

import com.benchwarmers.grads.grizzlystoregoogleuser.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name="GoogleAccount")
public class GoogleAccount extends Data {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Type(type="uuid-char")
    @Column(name = "id_Account", nullable = false, updatable = false)
    private UUID idAccount;

    @Column(name = "accountEmailAddress", nullable = false, unique = true)
    @Email
    private String accountEmailAddress;

    @CreationTimestamp
    @Column(name = "DateTime", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModified;



    @OneToOne(mappedBy = "googleAccount", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private GoogleProfile profile;

    public GoogleProfile getProfile() {
        return profile;
    }

    public void setProfile(GoogleProfile profile) {
        profile.setGoogleAccount(this);
        this.profile = profile;
    }
    public UUID getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(UUID idAccount) {
        this.idAccount = idAccount;
    }

    public String getAccountEmailAddress() {
        return accountEmailAddress;
    }

    public void setAccountEmailAddress(String accountEmailAddress) {
        this.accountEmailAddress = accountEmailAddress;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }
}
