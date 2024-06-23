package com.url.shortner.url_shortner.controller;

import com.url.shortner.url_shortner.domain.URLRecord;
import com.url.shortner.url_shortner.service.URLShorteningService;
import jakarta.servlet.http.HttpServletRequest;
import java.net.URI;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class RedirectionController {
  private final URLShorteningService urlShorteningService;

  @GetMapping("**")
  ResponseEntity<Void> redirect(HttpServletRequest request) {
    String requestUrl = request.getRequestURI();
    String url = StringUtils.removeFirst(requestUrl, "/");
    URLRecord urlRecord = urlShorteningService.find(url);

    return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(urlRecord.getUrl())).build();
  }
}
