package com.url.shortner.url_shortner.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@RequiredArgsConstructor
@EnableElasticsearchRepositories
public class ElasticDbConnectionConfig extends ElasticsearchConfiguration {

  private final ESConfig esConfig;

  @Override
  public ClientConfiguration clientConfiguration() {
    return ClientConfiguration.builder()
        .connectedTo(esConfig.getElasticDbHost() + ":" + esConfig.getElasticDbPort())
        .build();
  }
}
