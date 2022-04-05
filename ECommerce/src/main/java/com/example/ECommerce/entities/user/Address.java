package com.example.ECommerce.entities.user;


import javax.persistence.*;

@Entity
@Table(name="Address")
public class Address {

    /*
    ID
    CITY
    STATE
    COUNTRY
    ADDRESS_LINE
    ZIP_CODE
    LABEL (Ex. office/home)
    USER_ID
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   Long id;
    String city;
    String state;
    String Country;
    String addressLine;
    String zipCode;
    String label;
//   Integer userId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getAddressLine() {
        return addressLine;
    }

    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }



}