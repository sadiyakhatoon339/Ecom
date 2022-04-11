package com.example.ECommerce.services;


import com.example.ECommerce.entities.user.User;
import com.example.ECommerce.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class AdminService {

    @Autowired
    UserRepo userRepo;


    @Transactional
    public boolean activate(String email){
        User user=userRepo.findByEmail(email);
        if(user.getEmail().equals(email)){
            if(!user.getActive()==true){
                user.setActive(true);
                userRepo.updateUser(email);
            }
            return true;
        }
        else return false;

    }



}
