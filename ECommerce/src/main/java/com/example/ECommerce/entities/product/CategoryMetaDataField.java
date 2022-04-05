package com.example.ECommerce.entities.product;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CategoryMetaDataField {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String Name;
}
