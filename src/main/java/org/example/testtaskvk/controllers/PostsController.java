package org.example.testtaskvk.controllers;

import org.example.testtaskvk.models.Post;
import org.example.testtaskvk.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/posts")
public class PostsController {
    @Autowired
    private RestTemplate restTemplate;

    @Cacheable("postsCache")
    @GetMapping
    public ResponseEntity<String> getPosts() {
        return restTemplate.getForEntity("https://jsonplaceholder.typicode.com/posts", String.class);
    }

    @Cacheable("postByIdCache")
    @GetMapping("/{id}")
    public Post getPostById(@PathVariable int id){
        return restTemplate.getForObject("https://jsonplaceholder.typicode.com/posts/" + id, Post.class);
    }

    @DeleteMapping("/{id}")
    public void removePost(@PathVariable int id){
        restTemplate.delete("https://jsonplaceholder.typicode.com/posts/" + id);
    }

    @PutMapping("/{id}")
    public void updatePostById(@PathVariable int id, @RequestBody Post updatedPost) {
        restTemplate.put("https://jsonplaceholder.typicode.com/users/" + id, updatedPost, String.class);
    }

    @PostMapping
    public ResponseEntity<String> postPost(@RequestBody Post newPost){
        return restTemplate.postForEntity("https://jsonplaceholder.typicode.com/users", newPost, String.class);
    }

}
