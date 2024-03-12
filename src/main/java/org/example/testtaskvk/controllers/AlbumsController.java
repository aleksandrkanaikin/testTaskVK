package org.example.testtaskvk.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/albums")
public class AlbumsController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public String getAlbums() {
        String albumsJson = restTemplate.getForObject("https://jsonplaceholder.typicode.com/albums", String.class);
        return albumsJson;
    }
}
