package com.example.ECommerce.entities.product;

public class Category {
/*
ID
NAME
PARENT_CATEGORY_ID (This is category directly preceding this category)********
*/


    int id;
    String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentCategField() {
        return parentCategField;
    }

    public void setParentCategField(String parentCategField) {
        this.parentCategField = parentCategField;
    }

    String parentCategField;




}
