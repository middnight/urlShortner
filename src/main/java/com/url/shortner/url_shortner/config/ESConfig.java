package com.url.shortner.url_shortner.config;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
@Getter
public class ESConfig {

  @Value("${es.db.host}")
  private String elasticDbHost;

  @Value("${es.db.port}")
  private String elasticDbPort;
}
