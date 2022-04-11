package com.example.ECommerce.controller;

import com.example.ECommerce.entities.user.Customer;
import com.example.ECommerce.entities.user.User;
import com.example.ECommerce.models.usermodels.CustomerModel;
import com.example.ECommerce.models.usermodels.LoginModel;
import com.example.ECommerce.models.usermodels.UserModel;
import com.example.ECommerce.services.UserService;
import com.example.ECommerce.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.parameters.P;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;


@RestController
public class UserController {

    @Autowired
    UserService userServices;

    @Autowired
    AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public User register(@RequestBody UserModel user){
        return userServices.save(user);
    }



    HashMap<String, Object> response = new HashMap<>();

    @PostMapping("/login")
    ResponseEntity<Map> login(@RequestBody LoginModel model) {

        try {
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(model.getUsername(), model.getPassword());
            Authentication authentication = authenticationManager.authenticate(authenticationToken);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            response.put("token", JwtUtils.create(authentication));

            return ResponseEntity.accepted().body(response);
        } catch (Exception e) {
            e.printStackTrace();

        }
        return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
    }




    //Not working

    @RequestMapping(value="/logout", method= RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/";
    }





}
