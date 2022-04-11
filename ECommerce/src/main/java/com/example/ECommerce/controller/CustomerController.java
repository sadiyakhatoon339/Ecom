package com.example.ECommerce.controller;




import com.example.ECommerce.entities.user.Customer;
import com.example.ECommerce.models.usermodels.CustomerModel;
import com.example.ECommerce.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/register-customer")
    public Customer registercustomer(@RequestBody CustomerModel customermodel){
        return customerService.customerRegister(customermodel);
    }

    @GetMapping("/get-customerz")
    public List<Customer> customer(){
        return customerService.getList();
    }
}
