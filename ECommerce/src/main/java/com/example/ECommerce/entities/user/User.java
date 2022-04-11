package com.example.ECommerce.entities.user;


import com.example.ECommerce.models.usermodels.UserModel;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="USER")
public class User {
    /*
    ID
    EMAIL
    FIRST_NAME
    MIDDLE_NAME
    LAST_NAME
    PASSWORD
    IS_DELETED
    IS_ACTIVE
    IS_EXPIRED
    IS_LOCKED
    INVALID_ATTEMPT_COUNT
    PASSWORD_UPDATE_DATE
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String email;
    String firstName;
    String middleName;
    String lastName;
    String password;
    Boolean isDeleted;
    Boolean isActive;
    Boolean isExpired;
    Boolean isLocked;
    Integer invalidAttemptCount;
    Date passwordUpdateDate;

    @Transient
    public String resetPasswordToken;

    public User(){}


    public User(UserModel userModel){
        if(userModel != null){
            this.firstName = userModel.getFirstName();
            this.middleName = userModel.getMiddleName();
            this.lastName = userModel.getLastName();
            this.email = userModel.getEmail();
            this.password= userModel.getPassword();
        }
    }



    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    Customer customer;

    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "seller_id")
    Seller seller;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    Set<Address> addresses;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    List<Role> roles;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Boolean getExpired() {
        return isExpired;
    }

    public void setExpired(Boolean expired) {
        isExpired = expired;
    }

    public Boolean getLocked() {
        return isLocked;
    }

    public void setLocked(Boolean locked) {
        isLocked = locked;
    }

    public Integer getInvalidAttemptCount() {
        return invalidAttemptCount;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public void setInvalidAttemptCount(Integer invalidAttemptCount) {
        this.invalidAttemptCount = invalidAttemptCount;
    }

    public Date getPasswordUpdateDate() {
        return passwordUpdateDate;
    }

    public void setPasswordUpdateDate(Date passwordUpdateDate) {
        this.passwordUpdateDate = passwordUpdateDate;
    }

    public String getResetPasswordToken() {
        return resetPasswordToken;
    }

    public void setResetPasswordToken(String resetPasswordToken) {
        this.resetPasswordToken = resetPasswordToken;
    }
}