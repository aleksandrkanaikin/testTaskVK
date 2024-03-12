package org.example.testtaskvk.controllers;

import org.example.testtaskvk.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/users")
public class UsersController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public String getUsers() {
         return restTemplate.getForObject("https://jsonplaceholder.typicode.com/users", String.class);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id) {
        return restTemplate.getForObject("https://jsonplaceholder.typicode.com/users/" + id, User.class);
    }

    @DeleteMapping("/{id}")
    public void removeUserById(@PathVariable int id) {
        restTemplate.delete("https://jsonplaceholder.typicode.com/users/" + id);
    }

    @PutMapping("/{id}")
    public String updateUserById(@PathVariable int id) {
        return restTemplate.getForObject("https://jsonplaceholder.typicode.com/users/" + id, String.class);
    }

    @PostMapping
    public ResponseEntity<User> postUser(@RequestBody User newUser){
        return restTemplate.postForEntity("https://jsonplaceholder.typicode.com/users", newUser, User.class);
    }
}
