package com.example.ECommerce.filters;


import com.example.ECommerce.services.UserService;
import com.example.ECommerce.utils.JwtUtils;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@Component
//@Order(2)
public class AuthenticationFilter extends OncePerRequestFilter {
    @Autowired
    UserService userServices;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String authToken = request.getHeader("X-AUTH-TOKEN");
        UsernamePasswordAuthenticationToken authentication = null;
        String username = null;

            try {
                username = JwtUtils.getUsername(authToken);
            } catch (IllegalArgumentException e) {
                logger.error("an error occured during getting username from token", e);
            } catch (ExpiredJwtException e) {
                logger.error("the token is expired and not valid anymore", e);
            } catch (SignatureException e) {
                logger.error("Authentication Failed. Username or Password not valid.");
            }



            UserDetails userDetails;
            try {
                userDetails = userServices.loadUserByUsername(username);
                if (JwtUtils.validate(authToken, userDetails)) {
                    authentication = JwtUtils.getAuthentication(authToken, userDetails);
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                } else {

                        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                        return;

                }
            } catch (UsernameNotFoundException e) {
                logger.error("Failed to load userDetails from token.");

                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                    return;

            }

        SecurityContextHolder.getContext().setAuthentication(authentication);
        filterChain.doFilter(request, response);
    }
}