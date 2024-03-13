package org.example.testtaskvk.controllers;

import org.example.testtaskvk.models.AuntificationUser;
import org.example.testtaskvk.repository.AuntificationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/adduser")
public class NewUserController {

    @Autowired
    private AuntificationUserRepository repository;
    private PasswordEncoder passwordEncoder;

    @PostMapping
    public String addNewAutintificationUser(@RequestBody AuntificationUser newUser){
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        repository.save(newUser);
        return "New user added!";
    }
}
