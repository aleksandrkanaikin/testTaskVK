package org.example.testtaskvk.controllers;

import org.example.testtaskvk.models.Post;
import org.example.testtaskvk.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/posts")
public class PostsController {
    @Autowired
    private RestTemplate restTemplate;

    @Cacheable("postsCache")
    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN') && hasAuthority('ROLE_POSTS')")
    public ResponseEntity<String> getPosts() {
        return restTemplate.getForEntity("https://jsonplaceholder.typicode.com/posts", String.class);
    }

    @Cacheable("postByIdCache")
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN') && hasAuthority('ROLE_POSTS')")
    public Post getPostById(@PathVariable int id){
        return restTemplate.getForObject("https://jsonplaceholder.typicode.com/posts/" + id, Post.class);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN') && hasAuthority('ROLE_POSTS')")
    public void removePost(@PathVariable int id){
        restTemplate.delete("https://jsonplaceholder.typicode.com/posts/" + id);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN') && hasAuthority('ROLE_POSTS')")
    public void updatePostById(@PathVariable int id, @RequestBody Post updatedPost) {
        restTemplate.put("https://jsonplaceholder.typicode.com/users/" + id, updatedPost, String.class);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN') && hasAuthority('ROLE_POSTS')")
    public ResponseEntity<String> postPost(@RequestBody Post newPost){
        return restTemplate.postForEntity("https://jsonplaceholder.typicode.com/users", newPost, String.class);
    }

}
