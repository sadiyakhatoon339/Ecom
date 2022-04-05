package com.example.ECommerce.entities.order;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity

public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
//
//    DATE_CREATED
//    PAYMENT_METHOD
//    CUSTOMER_ADDRESS_CITY
//    CUSTOMER_ADDRESS_STATE
//    CUSTOMER_ADDRESS_COUNTRY
//    CUSTOMER_ADDRESS_ADDRESS_LINE
//    CUSTOMER_ADDRESS_ZIP_CODE
//    CUSTOMER_ADDRESS_LABEL (Ex. office/home)


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


    Date dateCreated;
    String paymentMethod;
    String  customerAddressCity;
    String customerAddressState;
    String customerAddressCountry;
    String customerAddressLine;
    String customerAddressZipCode;
    String customerAddressLabel;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getCustomerAddressCity() {
        return customerAddressCity;
    }

    public void setCustomerAddressCity(String customerAddressCity) {
        this.customerAddressCity = customerAddressCity;
    }

    public String getCustomerAddressState() {
        return customerAddressState;
    }

    public void setCustomerAddressState(String customerAddressState) {
        this.customerAddressState = customerAddressState;
    }

    public String getCustomerAddressCountry() {
        return customerAddressCountry;
    }

    public void setCustomerAddressCountry(String customerAddressCountry) {
        this.customerAddressCountry = customerAddressCountry;
    }

    public String getCustomerAddressLine() {
        return customerAddressLine;
    }

    public void setCustomerAddressLine(String customerAddressLine) {
        this.customerAddressLine = customerAddressLine;
    }

    public String getCustomerAddressZipCode() {
        return customerAddressZipCode;
    }

    public void setCustomerAddressZipCode(String customerAddressZipCode) {
        this.customerAddressZipCode = customerAddressZipCode;
    }

    public String getCustomerAddressLabel() {
        return customerAddressLabel;
    }

    public void setCustomerAddressLabel(String customerAddressLabel) {
        this.customerAddressLabel = customerAddressLabel;
    }
}
