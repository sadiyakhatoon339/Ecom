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
public class CustomerService {


    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private CustomerRepository customerRepository;

    public Customer customerRegister(CustomerModel customerModel){
        Customer customer=new Customer(customerModel);
        User user =new User();
        user.setEmail(customerModel.getEmail());
        user.setFirstName(customerModel.getFirstName());
        user.setMiddleName(customerModel.getMiddleName());

        //Encoding password
        user.setPassword(bCryptPasswordEncoder.encode(customerModel.getPassword()));

        user.setLastName(customerModel.getLastName());

        //setting customer into user
        customer.setUser(user);
        customerRepository.save(customer);

        return customer;


    }

    public List<Customer> getList(){
        List<Customer> customers= customerRepository.findAll();
        return customers;
    }
}



//
//import com.example.ECommerce.entities.user.Customer;
//import com.example.ECommerce.entities.user.User;
//import com.example.ECommerce.models.usermodels.CustomerModel;
//import com.example.ECommerce.repo.CustomerRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//
//@Service
//public class CustomerService {
//
//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;
//
//    @Autowired
//    private CustomerRepository customerRepository;
//
//
//
//    public Customer customerRegister(CustomerModel customerModel){
//        Customer customer=new Customer(customerModel);
//        User user =new User();
//        user.setEmail(customerModel.getEmail());
//        user.setFirstName(customerModel.getFirstName());
//        user.setMiddleName(customerModel.getMiddleName());
//        //Encoding password
//        user.setPassword(bCryptPasswordEncoder.encode(customerModel.getPassword()));
//        user.setLastName(customerModel.getLastName());
//
//        //setting customer into user
//        customer.setUser(user);
//        customerRepository.save(customer);
//        return customer;
//
//
//    }
//
//
//
//    public List<Customer> getList(){
//        List<Customer> customers= customerRepository.findAll();
//        return customers;
//    }
//}
