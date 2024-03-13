package org.example.testtaskvk.controllers;

import org.example.testtaskvk.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/users")
public class UsersController {
    @Autowired
    private RestTemplate restTemplate;

    @Cacheable("usersCache")
    @GetMapping
    public String getUsers() {
         return restTemplate.getForObject("https://jsonplaceholder.typicode.com/users", String.class);
    }

    @Cacheable("userByIdCache")
    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id) {
        return restTemplate.getForObject("https://jsonplaceholder.typicode.com/users/" + id, User.class);
    }

    @DeleteMapping("/{id}")
    public void removeUserById(@PathVariable int id) {
        restTemplate.delete("https://jsonplaceholder.typicode.com/users/" + id);
    }

    @PutMapping("/{id}")
    public void updateUserById(@PathVariable int id, @RequestBody User updateUser) {
        restTemplate.put("https://jsonplaceholder.typicode.com/users/" + id, updateUser, String.class);
    }

    @PostMapping
    public ResponseEntity<String> postUser(@RequestBody User newUser){
        return restTemplate.postForEntity("https://jsonplaceholder.typicode.com/users", newUser, String.class);
    }
}
