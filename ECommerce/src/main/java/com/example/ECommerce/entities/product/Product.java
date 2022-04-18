package com.example.ECommerce.entities.product;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {

//    ID
//    SELLER_USER_ID  ****
//    NAME
//    DESCRIPTION
//    CATEGORY_ID
//    IS_CANCELLABLE
//    IS_RETURNABLE
//    BRAND
//    IS_ACTIVE
//    IS_DELETED

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String Name;
    String description;
    int categoryId;
    Boolean isCancellable;
    Boolean isReturnable;
    String brand;
    Boolean isActive;
    Boolean isDeleted;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Boolean getCancellable() {
        return isCancellable;
    }

    public void setCancellable(Boolean cancellable) {
        isCancellable = cancellable;
    }

    public Boolean getReturnable() {
        return isReturnable;
    }

    public void setReturnable(Boolean returnable) {
        isReturnable = returnable;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
