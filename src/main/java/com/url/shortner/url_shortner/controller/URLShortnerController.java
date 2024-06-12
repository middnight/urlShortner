package com.url.shortner.url_shortner.controller;

import com.url.shortner.url_shortner.domain.URLRecord;
import com.url.shortner.url_shortner.service.URLShorteningService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/short")
@RequiredArgsConstructor
public class URLShortnerController {
  private final URLShorteningService urlShorteningService;

  @PostMapping
  ResponseEntity<URLRecord> create(@RequestParam String url) {
    return ResponseEntity.ok(urlShorteningService.create(url));
  }

  @GetMapping
  ResponseEntity<URLRecord> find(@RequestParam String url) {
    return ResponseEntity.ok(urlShorteningService.find(url));
  }

  @DeleteMapping
  ResponseEntity<URLRecord> delete(@RequestParam String url) {
    return ResponseEntity.ok(urlShorteningService.delete(url));
  }
}
