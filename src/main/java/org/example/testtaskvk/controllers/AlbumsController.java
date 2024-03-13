package org.example.testtaskvk.controllers;

import org.example.testtaskvk.models.Album;
import org.example.testtaskvk.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/albums")
public class AlbumsController {
    @Autowired
    private RestTemplate restTemplate;

    @Cacheable("albumsCache")
    @GetMapping
    public String getAlbums() {
        return restTemplate.getForObject("https://jsonplaceholder.typicode.com/albums", String.class);
    }

    @Cacheable("albumByIdCache")
    @GetMapping("/{id}")
    public Album getAlbumById(@PathVariable int id) {
        return restTemplate.getForObject("https://jsonplaceholder.typicode.com/albums/" + id, Album.class);
    }

    @DeleteMapping("/{id}")
    public void removeAlbumById(@PathVariable int id) {
        restTemplate.delete("https://jsonplaceholder.typicode.com/albums/" + id);
    }

    @PutMapping("/{id}")
    public void updateAlbumById(@PathVariable int id, @RequestBody Album updateAlbum) {
        restTemplate.put("https://jsonplaceholder.typicode.com/albums/" + id, updateAlbum, String.class);
    }

    @PostMapping
    public ResponseEntity<String> postAlbum(@RequestBody Album newAlbum){
        return restTemplate.postForEntity("https://jsonplaceholder.typicode.com/albums", newAlbum, String.class);
    }
}
