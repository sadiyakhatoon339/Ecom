package com.example.ECommerce.entities.order;

import com.example.ECommerce.entities.user.Customer;

import javax.persistence.*;

//@Entity
public class Cart {


    /*
CUSTOMER_USER_ID****
QUANTITY
IS_WISHLIST_ITEM-----
PRODUCT_VARIATION_ID*****
*/



//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @ManyToOne(optional = false)
//    @JoinColumn(name = "customer_user_id", nullable = false)
//    Customer customer;


    int customeruserId;
    int quantity;

    public int getCustomeruserId() {
        return customeruserId;
    }

    public void setCustomeruserId(int customeruserId) {
        this.customeruserId = customeruserId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Boolean getWishListItem() {
        return isWishListItem;
    }

    public void setWishListItem(Boolean wishListItem) {
        isWishListItem = wishListItem;
    }

    public int getProductVariationId() {
        return productVariationId;
    }

    public void setProductVariationId(int productVariationId) {
        this.productVariationId = productVariationId;
    }

    Boolean isWishListItem;
    int productVariationId;





}
