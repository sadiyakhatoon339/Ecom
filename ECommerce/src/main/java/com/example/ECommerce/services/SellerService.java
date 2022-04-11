package com.example.ECommerce.services;

import com.example.ECommerce.entities.user.Customer;
import com.example.ECommerce.entities.user.Seller;
import com.example.ECommerce.entities.user.User;
import com.example.ECommerce.models.usermodels.CustomerModel;
import com.example.ECommerce.models.usermodels.SellerModel;
import com.example.ECommerce.repo.CustomerRepository;
import com.example.ECommerce.repo.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerService {


    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private SellerRepository sellerRepository;

    public Seller sellerRegister(SellerModel sellerModel){
        Seller seller=new Seller(sellerModel);
        User user =new User();
        user.setEmail(sellerModel.getEmail());
        user.setFirstName(sellerModel.getFirstName());
        user.setMiddleName(sellerModel.getMiddleName());

        //Encoding password
        user.setPassword(bCryptPasswordEncoder.encode(sellerModel.getPassword()));

        user.setLastName(sellerModel.getLastName());

        //setting customer into user
        seller.setUser(user);
        sellerRepository.save(seller);

        return seller;


    }

    public List<Seller> getList(){
        List<Seller> sellers= sellerRepository.findAll();
        return sellers;
    }
}
