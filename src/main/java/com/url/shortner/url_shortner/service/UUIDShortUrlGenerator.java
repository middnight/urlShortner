package com.url.shortner.url_shortner.service;

import java.util.UUID;
import org.springframework.stereotype.Component;

@Component
public class UUIDShortUrlGenerator implements ShortUrlGenerator {
  @Override
  public String generate(String url) {
    return UUID.randomUUID().toString().replace("-", "");
    // TODO check if same string is already not in db
  }

  @Override
  public String getStrategy() {
    return "uuid";
  }
}
