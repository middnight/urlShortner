package com.url.shortner.url_shortner.service;

public interface ShortUrlGenerator {

  String generate(String url);

  String getStrategy();
}
