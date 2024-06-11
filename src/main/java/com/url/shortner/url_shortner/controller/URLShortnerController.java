package com.url.shortner.url_shortner.controller;

import com.url.shortner.url_shortner.domain.URLRecord;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/short")
public class URLShortnerController {

    @PostMapping
    ResponseEntity<URLRecord> create(
            @RequestParam String url){

        return null;
    }

    @GetMapping
    ResponseEntity<URLRecord> find(@RequestParam String url){


        return null;
    }

    @DeleteMapping
    ResponseEntity<URLRecord> delete(@RequestParam String url){
        return null;
    }
}
