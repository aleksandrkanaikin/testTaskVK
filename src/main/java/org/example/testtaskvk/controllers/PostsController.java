package org.example.testtaskvk.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/posts")
public class PostsController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public ResponseEntity<String> getPosts() {
        return restTemplate.getForEntity("https://jsonplaceholder.typicode.com/posts", String.class);
    }
}
