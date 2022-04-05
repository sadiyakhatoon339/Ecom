package com.example.ECommerce.entities.order;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


public class OrderStatus {

    /*
 ORDER_PRODUCT_ID*****
FROM_STATUS
TO_STATUS
TRANSITION_NOTES_COMMENTS
*/


    int orderProductId;
    String frmStatus;
    String toStatus;

    public int getOrderProductId() {
        return orderProductId;
    }

    public void setOrderProductId(int orderProductId) {
        this.orderProductId = orderProductId;
    }

    public String getFrmStatus() {
        return frmStatus;
    }

    public void setFrmStatus(String frmStatus) {
        this.frmStatus = frmStatus;
    }

    public String getToStatus() {
        return toStatus;
    }

    public void setToStatus(String toStatus) {
        this.toStatus = toStatus;
    }

    public String getTransactionalNotesComponents() {
        return transactionalNotesComponents;
    }

    public void setTransactionalNotesComponents(String transactionalNotesComponents) {
        this.transactionalNotesComponents = transactionalNotesComponents;
    }

    String transactionalNotesComponents;








}


