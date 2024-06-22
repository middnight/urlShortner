package com.url.shortner.url_shortner.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class ESConfig {

  @Value("${es.db.host}")
  private String elasticDbHost;

  @Value("${es.db.port}")
  private String elasticDbPort;
}
