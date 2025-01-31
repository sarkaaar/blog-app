package com.blog.app.configs.services;


import com.blog.app.Entity.Users;
import com.blog.app.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Users> user = userRepository.findByUsername(email);
        return new User(user.get().getUsername(), user.get().getPassword(), new ArrayList<>());
    }

//    public UserDetails loadUserByEmail(String email) {
//        Users user;
//        try {
//            user = userRepository.findByEmail(email);
//        } catch (Exception e) {
//            throw new UsernameNotFoundException("User not found with email: " + email);
//        }
//        return new User(user.getEmail(), user.getPassword(), new ArrayList<>());
//    }
//
//    public UserDetails loadUserByPhoneNumber(String phoneNumber) {
//
//        Users user;
//        try {
//            user = userRepository.findByPhone(phoneNumber);
//        } catch (Exception e) {
//            throw new UsernameNotFoundException("User not found with phone number: " + phoneNumber);
//        }
//        return new User(user.getPhone(), user.getPassword(), new ArrayList<>());
//    }

}