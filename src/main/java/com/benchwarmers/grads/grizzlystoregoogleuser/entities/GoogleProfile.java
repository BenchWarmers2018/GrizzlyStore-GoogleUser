package com.benchwarmers.grads.grizzlystoregoogleuser.entities;

import com.benchwarmers.grads.grizzlystoregoogleuser.Data;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Profile")
public class GoogleProfile extends Data {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_Profile", nullable = false)
    private Integer idProfile;

    @Column(name = "profile_FirstName")
    private String profileFirstName;

    @Column(name = "profile_LastName")
    private String profileLastName;

    @Column(name = "profile_PhoneNumber")
    private String profilePhoneNumber;

    @Column(name = "profile_Image")
    private String profileImage;

    @CreationTimestamp
    @Column(name = "last_modified", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModified;

    @OneToOne(cascade =  CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name = "id_googleaccount_foreign", nullable = false)
    @JsonIgnore
    private GoogleAccount googleAccount;


    public void setGoogleAccount(GoogleAccount googleAccount) {
        this.googleAccount = googleAccount;
    }
    //Getter and Setters.
    public GoogleAccount getGoogleAccount() {
        return googleAccount;
    }

    public void setUserAccount(GoogleAccount googleAccount) {
        this.googleAccount = googleAccount;
    }

    public Integer getIdProfile() {
        return idProfile;
    }

    public void setIdProfile(Integer id_Profile) {
        this.idProfile = id_Profile;
    }

    public String getProfileFirstName() {
        return profileFirstName;
    }

    public void setProfileFirstName(String profile_FirstName) {
        this.profileFirstName = profile_FirstName;
    }

    public String getProfileLastName() {
        return profileLastName;
    }

    public void setProfileLastName(String profile_LastName) {
        this.profileLastName = profile_LastName;
    }

    public String getProfilePhoneNumber() {
        return profilePhoneNumber;
    }

    public void setProfilePhoneNumber(String profile_PhoneNumber) {
        this.profilePhoneNumber = profile_PhoneNumber;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profile_Image) {
        this.profileImage = profile_Image;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date last_modified) {
        this.lastModified = last_modified;
    }
}
