package com.url.shortner.url_shortner.service;

import com.url.shortner.url_shortner.domain.URLRecord;

public interface URLShorteningService {

  URLRecord create(String url);

  URLRecord find(String shortUrl);

  URLRecord delete(String shortUrl);

  void deleteExpired();
}
