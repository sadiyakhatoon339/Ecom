package com.example.ECommerce.entities.product;

public class ProductVariation {

     /*ID
PRODUCT_ID******
QUANTITY_AVAILABLE
PRICE
"""METADATA (Type: JSON - available in mysql to store a JSON as it is.)
(Note: will contain all the information regarding variations in flat JSON format)
(All variations of same category will have a fixed similar JSON structure.
The fields for the json should be picked from CATEGORY table)"""
PRIMARY_IMAGE_NAME
"IS_ACTIVE
(NEW FIELD)"

*/

    int id;
    int quantityAvailable;
    Double price;
    Boolean isActive;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantityAvailable() {
        return quantityAvailable;
    }

    public void setQuantityAvailable(int quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
