package com.url.shortner.url_shortner.controller;

import com.url.shortner.url_shortner.domain.URLRecord;
import com.url.shortner.url_shortner.service.URLShorteningService;
import javax.annotation.Nonnull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class URLShortnerController {
  private final URLShorteningService urlShorteningService;

  @PostMapping("/shorten")
  String create(@RequestParam("longUrl") String longUrl, Model model) {
    URLRecord urlRecord = urlShorteningService.create(longUrl);
    model.addAttribute("shortUrl", urlRecord.getShortUrl());
    return "urlForm";
  }

  @GetMapping
  String showUrlForm() {
    return "urlForm";
  }

  @GetMapping("/find")
  ResponseEntity<URLRecord> find(@RequestParam @Nonnull String shortUrl) {
    return ResponseEntity.ok(urlShorteningService.find(shortUrl));
  }

  @DeleteMapping
  ResponseEntity<URLRecord> delete(@RequestParam @Nonnull String shortUrl) {
    return ResponseEntity.ok(urlShorteningService.delete(shortUrl));
  }
}
