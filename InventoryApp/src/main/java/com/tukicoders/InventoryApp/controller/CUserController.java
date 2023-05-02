package com.tukicoders.InventoryApp.controller;

import com.tukicoders.InventoryApp.exception.UserNotFoundException;
import com.tukicoders.InventoryApp.model.CUser;
import com.tukicoders.InventoryApp.repository.CUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
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

    @GetMapping("/user/{id}")
    CUser getUserById(@PathVariable Long id){
        return cUserRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    @PutMapping("/user/{id}")
    CUser updateUser(@RequestBody CUser newUser, @PathVariable Long id){
        return cUserRepository.findById(id)
                .map(user -> {
                    user.setUsername(newUser.getUsername());
                    user.setName(newUser.getName());
                    user.setEmail(newUser.getEmail());
                    return cUserRepository.save(user);
        }).orElseThrow(()-> new UserNotFoundException(id));
    }

    @DeleteMapping("/user/{id}")
    String deleteUser(@PathVariable Long id){
        if (!cUserRepository.existsById(id)){
            throw new UserNotFoundException(id);
        }
        cUserRepository.deleteById(id);
        return "User with id "+id+ " has been deleted success.";
    }
}
