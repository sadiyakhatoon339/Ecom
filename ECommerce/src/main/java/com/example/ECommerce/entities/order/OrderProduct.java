package com.example.ECommerce.entities.order;

public class OrderProduct {

    /*
 ID
ORDER_ID****
QUANTITY
PRICE
PRODUCT_VARIATION_ID****
*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOderdId() {
        return oderdId;
    }

    public void setOderdId(int oderdId) {
        this.oderdId = oderdId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getProductVariationId() {
        return productVariationId;
    }

    public void setProductVariationId(int productVariationId) {
        this.productVariationId = productVariationId;
    }

    int id;
  int oderdId;
  int quantity;
  double price;
  int productVariationId;




}
