package com.tukicoders.InventoryApp.controller;

import com.tukicoders.InventoryApp.model.CUser;
import com.tukicoders.InventoryApp.repository.CUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CUserController {

    @Autowired
    private CUserRepository cUserRepository;

    @PostMapping("/user")
    CUser newUser(@RequestBody CUser newUser){
        return cUserRepository.save(newUser);
    }

    @GetMapping("/users")
    List<CUser> getAllUsers(){
        return cUserRepository.findAll();
    }
}