package com.url.shortner.url_shortner.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShortUrlGeneratorStrategyProvider {

  private final List<ShortUrlGenerator> urlGenerators;

  public ShortUrlGenerator getByStrategy(String strategy) {
    return urlGenerators.stream()
        .filter(generator -> generator.getStrategy().equalsIgnoreCase(strategy))
        .findFirst()
        .orElseThrow(() -> new NotImplementedException("Given Strategy is not implemented"));
  }
}
