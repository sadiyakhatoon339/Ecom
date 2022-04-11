package com.example.ECommerce.controller;


import com.example.ECommerce.entities.user.Customer;
import com.example.ECommerce.entities.user.Seller;
import com.example.ECommerce.models.usermodels.CustomerModel;
import com.example.ECommerce.models.usermodels.SellerModel;
import com.example.ECommerce.services.CustomerService;
import com.example.ECommerce.services.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SellerController {

    @Autowired
    private SellerService sellerService;

    @PostMapping("/register-seller")
    public Seller register(@RequestBody SellerModel sellermodel){
        return sellerService.sellerRegister(sellermodel);
    }

    @GetMapping("/get-sellers")
    public List<Seller> seller(){
        return sellerService.getList();
    }
}
