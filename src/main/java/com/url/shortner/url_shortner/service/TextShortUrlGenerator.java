package com.url.shortner.url_shortner.service;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TextShortUrlGenerator implements ShortUrlGenerator {
  @Value("${url.generator.strategy.string.min.length}")
  private int minLength;

  @Value("${url.generator.strategy.string.max.length}")
  private int maxLength;

  @Override
  public String generate(String url) {
    return RandomStringUtils.randomAlphanumeric(minLength, maxLength);
  }

  @Override
  public String getStrategy() {
    return "text";
  }
}
