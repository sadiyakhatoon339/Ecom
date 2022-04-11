package com.example.ECommerce.services;

import com.example.ECommerce.entities.user.Customer;
import com.example.ECommerce.entities.user.Role;
import com.example.ECommerce.entities.user.User;
import com.example.ECommerce.models.usermodels.CustomerModel;
import com.example.ECommerce.models.usermodels.UserModel;
import com.example.ECommerce.repo.CustomerRepository;
import com.example.ECommerce.repo.RoleRepository;
import com.example.ECommerce.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserRepo userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    EmailService emailService;

    @Autowired
    private  BCryptPasswordEncoder passwordEncoder;

    public  User save(UserModel userModel){
        User user = new User(userModel);
        user.setPassword(passwordEncoder.encode(userModel.getPassword()));
        List<Role> roles= roleRepository.findAllByIdIn(userModel.getRoles());
        user.setRoles(roles);
        userRepository.save(user);
        emailService.sendMail(user.getEmail(),"Registration !!!","welcome to the My Backend Application Service . This is your username "
                +user.getEmail()+" . Your Account is Deactivate .Please contact to the Admin to activate your Account.. Warm regards ");
        return user;
    }




    private Collection<? extends GrantedAuthority> getAuthorities(
            Collection<Role> roles) {
        List<GrantedAuthority> authorities
                = new ArrayList<>();
        for (Role role: roles) {
            authorities.add(new SimpleGrantedAuthority(role.getAuthority()));
        }

        return authorities;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("User Not Found for Email" + username);
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), getAuthorities(user.getRoles()));

    }



}