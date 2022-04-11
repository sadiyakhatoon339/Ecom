package com.example.ECommerce.controller;


import com.example.ECommerce.entities.user.Customer;
import com.example.ECommerce.entities.user.Seller;
import com.example.ECommerce.entities.user.User;
import com.example.ECommerce.models.usermodels.CustomerModel;
import com.example.ECommerce.services.AdminService;
import com.example.ECommerce.services.CustomerService;
import com.example.ECommerce.services.SellerService;
import com.example.ECommerce.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.GeneratedValue;
import java.util.List;

@RestController
public class AdminController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private SellerService sellerService;

    @Autowired
    private AdminService adminService;

    @GetMapping("/all-seller")
    public List<Seller> registerseller(){
        return sellerService.getList();
    }

//    @PostMapping("/activate-customer")
//    public boolean activateUser(String email){
//        return adminService.activate(email);


    @PutMapping("/activate-customer/{user}")
    public ResponseEntity<String> activateCustomer(@PathVariable String user){
        if (adminService.activate(user)) {
            return ResponseEntity.accepted().body("Customer Activated");
        }
        return new ResponseEntity<>("customer not activated", HttpStatus.NOT_FOUND);
    }

    @PutMapping("/activate-seller/{user}")
    public ResponseEntity<String> activateSeller(@PathVariable String user){
        if(adminService.activate(user)){
            return ResponseEntity.accepted().body("Seller Activated");
        }
        return new ResponseEntity<>("Seller not activated",HttpStatus.NOT_FOUND);
    }



    }







