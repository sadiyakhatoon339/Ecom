package com.example.ECommerce.controller;

import com.example.ECommerce.entities.user.User;
import com.example.ECommerce.models.usermodels.UserModel;
import com.example.ECommerce.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

    @Autowired
    UserService userServices;

    @PostMapping("/register")
    public User register(@RequestBody UserModel user){
        return userServices.save(user);
    }
    
}
